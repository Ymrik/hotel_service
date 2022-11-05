package com.umarbariev.projects.hotel_service.controllers;

import com.umarbariev.projects.hotel_service.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/")
    public String index(Model model) {
        var availableRooms = roomService.getAllAvailableRooms();
        model.addAttribute("availableRooms", availableRooms);
        return "index";
    }
}
