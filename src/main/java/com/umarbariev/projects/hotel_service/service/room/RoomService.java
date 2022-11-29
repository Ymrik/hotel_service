package com.umarbariev.projects.hotel_service.service.room;

import com.umarbariev.projects.hotel_service.dto.SearchCriteriaDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomTypeDto;
import com.umarbariev.projects.hotel_service.entities.room.Room;
import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;
import com.umarbariev.projects.hotel_service.entities.room.RoomType;
import com.umarbariev.projects.hotel_service.exception.NoSuchRoomTypeException;
import com.umarbariev.projects.hotel_service.repositories.room.RoomRepository;
import com.umarbariev.projects.hotel_service.service.order.OrderService;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomStatusService roomStatusService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private OrderService orderService;

    public List<RoomDto> getAllAvailableRooms() {
        var roomStatusAvailable = roomStatusService.roomStatusAvailable();
        return roomStatusAvailable == null ? null : roomRepository.findAllByRoomStatus(BasicConverter.convert(roomStatusAvailable, RoomStatus.class))
                .stream()
                .map(x -> BasicConverter.convert(x, RoomDto.class))
                .sorted(Comparator.comparing(o -> o.getRoomTypeDto().getBasePrice()))
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(x -> BasicConverter.convert(x, RoomDto.class))
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllRoomsAvailableOnDate(Date date) {
        var allRooms = findAllRooms();
        var availableRooms = new ArrayList<RoomDto>();
        for (RoomDto roomDto : allRooms) {
            if (roomDto.getRoomStatusDto().equals(RoomStatusDto.ROOM_STATUS_AVAILABLE)) {
                availableRooms.add(roomDto);
                continue;
            }
            var releaseDate = orderService.checkReleaseDate(roomDto);
            if (releaseDate.before(date)) availableRooms.add(roomDto);
        }
        availableRooms.sort(Comparator.comparing(o -> o.getRoomTypeDto().getBasePrice()));
        return availableRooms;
    }

    public RoomDto findAvailableRoomByRoomTypeId(int roomTypeId) {
        var roomTypeDto = roomTypeService.findById(roomTypeId);
        if (roomTypeDto == null) throw new NoSuchRoomTypeException();
        var roomType = BasicConverter.convert(roomTypeDto, RoomType.class);
        var roomStatusAvailable = BasicConverter.convert(RoomStatusDto.ROOM_STATUS_AVAILABLE, RoomStatus.class);
        var room = roomRepository.findFirstByRoomStatusAndRoomType(roomStatusAvailable, roomType).orElse(null);
        return room == null ? null : BasicConverter.convert(room, RoomDto.class);
    }

    public List<RoomTypeDto> getAllAvailableRoomTypes() {
        return getAllAvailableRooms()
                .stream()
                .map(RoomDto::getRoomTypeDto)
                .distinct()
                .sorted(Comparator.comparing(RoomTypeDto::getBasePrice))
                .collect(Collectors.toList());
    }

    public List<RoomTypeDto> getAvailableRoomTypesBySearchCriteria(SearchCriteriaDto searchCriteria) {
        return findAllRoomsAvailableOnDate(searchCriteria.getArrivalDate())
                .stream()
                .map(RoomDto::getRoomTypeDto)
                .filter(x -> x.getCapacity() >= searchCriteria.getGuestsCount())
                .distinct()
                .sorted(Comparator.comparing(RoomTypeDto::getBasePrice))
                .collect(Collectors.toList());
    }

    public RoomDto createOrUpdateRoom(Room room) {
        var roomSaved = roomRepository.save(room);
        return BasicConverter.convert(roomSaved, RoomDto.class);
    }
}
