package com.umarbariev.projects.hotel_service.controllers;

import com.umarbariev.projects.hotel_service.dto.SearchCriteriaDto;
import com.umarbariev.projects.hotel_service.dto.order.OrderRequest;
import com.umarbariev.projects.hotel_service.service.order.OrderService;
import com.umarbariev.projects.hotel_service.service.room.RoomService;
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

    @RequestMapping("/")
    public String index(Model model) {
        var availableRoomsTypes = roomService.getAllAvailableRoomTypes();
        model.addAttribute("availableRoomTypes", availableRoomsTypes);
        model.addAttribute("searchCriteria", new SearchCriteriaDto());
        return "index";
    }

    @RequestMapping("/findRoom")
    public String
    findRoom(@ModelAttribute SearchCriteriaDto searchCriteriaDto, Model model) {
        var foundedRoomTypes = roomService.getAvailableRoomTypesBySearchCriteria(searchCriteriaDto);
        model.addAttribute("foundedRoomTypes", foundedRoomTypes);
        return "founded-rooms";
    }

    @RequestMapping("/chooseRoomType")
    public String makeOrder(Model model) {
        var availableRoomTypes = roomService.getAllAvailableRoomTypes();
        model.addAttribute("availableRoomTypes",availableRoomTypes);
        return "choose-room-type";
    }

    @RequestMapping("/makeOrder")
    private String makeNewOrder(@RequestParam(name = "roomTypeId") int roomTypeId, Model model){
        var orderRequest = new OrderRequest();
        orderRequest.setRoomTypeId(roomTypeId);
        model.addAttribute("orderRequest", orderRequest);
        return "new-order";
    }

    @RequestMapping("/newOrder")
    private String newOrder(@ModelAttribute OrderRequest orderRequest, Model model){
        orderService.makeNewOrder(orderRequest);
        return "redirect:";
    }
}
