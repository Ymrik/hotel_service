package com.umarbariev.projects.hotel_service.controllers;

import com.umarbariev.projects.hotel_service.dto.SearchCriteriaDto;
import com.umarbariev.projects.hotel_service.dto.order.OrderRequest;
import com.umarbariev.projects.hotel_service.service.order.OrderService;
import com.umarbariev.projects.hotel_service.service.room.RoomService;
import com.umarbariev.projects.hotel_service.service.room.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping("/")
    public String index(Model model) {
        var availableRoomsTypes = roomService.getAllAvailableRoomTypes();
        model.addAttribute("availableRoomTypes", availableRoomsTypes);
        model.addAttribute("searchCriteria", new SearchCriteriaDto());
        return "index";
    }

    @RequestMapping("/findRoom")
    public String findRoom(@ModelAttribute SearchCriteriaDto searchCriteriaDto, Model model) {
        var foundedRoomTypes = roomService.getAvailableRoomTypesBySearchCriteria(searchCriteriaDto);
        model.addAttribute("foundedRoomTypes", foundedRoomTypes);
        var orderRequest = new OrderRequest();
        orderRequest.setCheckInDate(searchCriteriaDto.getArrivalDate());
        orderRequest.setCheckOutDate(searchCriteriaDto.getDepartureDate());
        orderRequest.setGuestsCount(searchCriteriaDto.getGuestsCount());
        model.addAttribute("orderRequest", orderRequest);
        return "founded-rooms";
    }

    @RequestMapping("/chooseRoomType")
    public String makeOrder(Model model) {
        var availableRoomTypes = roomService.getAllAvailableRoomTypes();
        model.addAttribute("availableRoomTypes", availableRoomTypes);
        return "choose-room-type";
    }

    @RequestMapping("/makeOrder")
    private String makeNewOrder(@ModelAttribute OrderRequest orderRequest,
                                @RequestParam(name = "roomTypeId") int roomTypeId, Model model) {
        if (orderRequest == null) orderRequest = new OrderRequest();
        orderRequest.setRoomTypeId(roomTypeId);
        var roomType = roomTypeService.findById(roomTypeId);
        model.addAttribute("roomType", roomType);
        model.addAttribute("orderRequest", orderRequest);
        return "new-order";
    }

    @RequestMapping("/newOrder")
    private String newOrder(@ModelAttribute OrderRequest orderRequest, Model model) {
        orderService.makeNewOrder(orderRequest);
        return "redirect:";
    }

    @RequestMapping("/roomDetails")
    private String showRoomDetails(@RequestParam(name = "roomTypeId") int roomTypeId, Model model) {
        var roomType = roomTypeService.findById(roomTypeId);
        model.addAttribute("roomType", roomType);
        return "room-type-details";
    }
}
