package com.umarbariev.projects.hotel_service.controllers;

import com.umarbariev.projects.hotel_service.dto.SearchCriteriaDto;
import com.umarbariev.projects.hotel_service.service.room.RoomService;
import com.umarbariev.projects.hotel_service.service.room.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping("/")
    public String index(Model model) {
        var availableRoomsTypes = roomTypeService.getAllAvailableRoomTypes();
        model.addAttribute("availableRoomTypes", availableRoomsTypes);
        model.addAttribute("searchCriteria", new SearchCriteriaDto());
        return "index";
    }

    @RequestMapping("/findRoom")
    public String findRoom(@ModelAttribute SearchCriteriaDto searchCriteriaDto) {
        var suitableRooms = roomTypeService.getAvailableRoomTypesBySearchCriteria(searchCriteriaDto);
        return "founded-rooms";
    }
}
