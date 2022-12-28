package com.umarbariev.projects.hotel_service.controllers;

import com.umarbariev.projects.hotel_service.dto.additionalService.AdditionalServiceDto;
import com.umarbariev.projects.hotel_service.dto.SearchCriteriaDto;
import com.umarbariev.projects.hotel_service.dto.additionalService.ClientAdditionalServiceDto;
import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import com.umarbariev.projects.hotel_service.dto.client.UserClientDto;
import com.umarbariev.projects.hotel_service.dto.order.OrderRequest;
import com.umarbariev.projects.hotel_service.dto.user.UserDto;
import com.umarbariev.projects.hotel_service.entities.User;
import com.umarbariev.projects.hotel_service.service.additionalService.AdditionalServiceService;
import com.umarbariev.projects.hotel_service.service.additionalService.ClientAdditionalServiceService;
import com.umarbariev.projects.hotel_service.service.client.ClientService;
import com.umarbariev.projects.hotel_service.service.client.SexService;
import com.umarbariev.projects.hotel_service.service.order.OrderService;
import com.umarbariev.projects.hotel_service.service.room.RoomService;
import com.umarbariev.projects.hotel_service.service.room.RoomTypeService;
import com.umarbariev.projects.hotel_service.service.user.UserService;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MvcController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private UserService userService;
    @Autowired
    private SexService sexService;
    @Autowired
    private AdditionalServiceService additionalServiceService;
    @Autowired
    private ClientAdditionalServiceService clientAdditionalServiceService;

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        var availableRoomsTypes = roomService.getAllAvailableRoomTypes();
        var services = additionalServiceService.getAllEnabledServices();
        model.addAttribute("availableRoomTypes", availableRoomsTypes);
        model.addAttribute("searchCriteria", new SearchCriteriaDto());
        model.addAttribute("services", services);
        model.addAttribute("user", principal);
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
    private String newOrder(@ModelAttribute OrderRequest orderRequest, Model model, Principal principal) {
        var client = clientService.findClientByUsername(principal.getName());
        orderRequest.setClientId(client.getId());
        orderService.makeNewOrder(orderRequest);
        return "redirect:";
    }

    @RequestMapping("/roomDetails")
    private String showRoomDetails(@RequestParam(name = "roomTypeId") int roomTypeId, Model model) {
        var roomType = roomTypeService.findById(roomTypeId);
        model.addAttribute("roomType", roomType);
        return "room-type-details";
    }

    @RequestMapping("/registration")
    private String registration(Model model) {
        model.addAttribute("userClient", new UserClientDto());
        return "registration";
    }

    @RequestMapping("/newClient")
    public String addNewClient(@ModelAttribute(name = "userClient") UserClientDto userClientDto) {
        var client = clientService.addNewClient(userClientDto);
        return "redirect:";
    }

    @RequestMapping("/personalAccount")
    public String personalAccount(Principal principal, Model model) {
        var client = clientService.findClientByUsername(principal.getName());
        model.addAttribute("client", client);
        return "personal-account";
    }

    @RequestMapping("/clientInfo")
    public String clientInfo(Principal principal, Model model) {
        var client = clientService.findClientByUsername(principal.getName());
        model.addAttribute("client", client);
        return "client-info";
    }

    @RequestMapping("/changePassword")
    public String changePassword(Principal principal, Model model) {
        var user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "change-password";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.changeUser(BasicConverter.convert(user, UserDto.class));
        return "redirect:/personalAccount";
    }

    @RequestMapping("/loyaltyStatus")
    public String loyaltyStatus(Principal principal, Model model) {
        var client = clientService.findClientByUsername(principal.getName());
        var infoForNextLoyalStatus = clientService.getInfoUntilNextLoyaltyStatus(client);
        model.addAttribute("client", client);
        model.addAttribute("infoForNextStatus", infoForNextLoyalStatus);
        return "loyalty-status";
    }

    @RequestMapping("/changeInfo")
    public String changeInfo(Principal principal, Model model) {
        var client = clientService.findClientByUsername(principal.getName());
        model.addAttribute("client", client);
        return "change-info";
    }

    @RequestMapping("/updateClient")
    public String updateClient(@ModelAttribute ClientDto clientDto) {
        var sex = sexService.findByName(clientDto.getSexDto().getName());
        clientDto.setSexDto(sex);
        clientService.saveClient(clientDto);
        return "redirect:/clientInfo";
    }

    @RequestMapping("/settings")
    public String settings() {
        return "settings";
    }

    @RequestMapping("/clientOrders")
    public String clientOrders(Principal principal, Model model) {
        var client = clientService.findClientByUsername(principal.getName());
        var activeOrders = orderService.getActiveOrdersByClient(client);
        var finishedOrders = orderService.getFinishedOrdersByClient(client);
        var services = clientAdditionalServiceService.getAllByClient(client);
        model.addAttribute("clientServices", services);
        model.addAttribute("activeOrders", activeOrders);
        model.addAttribute("finishedOrders", finishedOrders);
        return "client-orders";
    }

    @RequestMapping("/serviceDetails")
    public String serviceDetails(@RequestParam(name = "serviceId") int serviceId, Model model, Principal principal) {
        var service = additionalServiceService.getServiceById(serviceId);
        var client = clientService.findClientByUsername(principal.getName());
        var clientAdditionalService = clientAdditionalServiceService.create(client, service);
        model.addAttribute("clientService", clientAdditionalService);
        return "service-details";
    }

    @RequestMapping("/infoBuyService")
    public String infoBuyService(@RequestParam(name = "serviceId") int serviceId, Model model, Principal principal) {
        var service = additionalServiceService.getServiceById(serviceId);
        var client = clientService.findClientByUsername(principal.getName());
        var clientAdditionalService = clientAdditionalServiceService.create(client, service);
        model.addAttribute("clientService", clientAdditionalService);
        return "buy-service";
    }

    @RequestMapping("/buyService")
    public String buyService(@ModelAttribute ClientAdditionalServiceDto clientService) {
        clientAdditionalServiceService.buyService(clientService);
        return "redirect:/";
    }
}
