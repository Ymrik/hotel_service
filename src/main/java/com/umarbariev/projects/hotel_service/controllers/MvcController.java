package com.umarbariev.projects.hotel_service.controllers;

import com.umarbariev.projects.hotel_service.service.room.RoomService;
import com.umarbariev.projects.hotel_service.service.room.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "index";
    }
}
