package com.enfor.myapp.controller;

import com.enfor.myapp.entity.*;
import com.enfor.myapp.repository.*;
import com.enfor.myapp.service.CarService;
import com.enfor.myapp.service.FileService;
import com.enfor.myapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class NewsController {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private CarService carService;

    @Autowired
    private RegionsRepository regionsRepository;

    @Autowired
    private CitiesRepository citiesRepository;

    @Autowired
    private StreetsRepository streetsRepository;

    @Autowired
    private RoadObjectsRepository roadObjectsRepository;

    @Autowired
    private StatusesRepository statusesRepository;

    @Autowired
    private ModelOfCarRepository modelOfCarRepository;

    @Autowired
    private TypeOfBodyRepository typeOfBodyRepository;

    @Autowired
    private TypeOfTransportRepository typeOfTransportRepository;

    @Autowired
    private BrandOfCarRepository brandOfCarRepository;

    @GetMapping("/index")
    public String index(@RequestParam(required = false, defaultValue = "") String filter,
                        Model model,
                        @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {    //параметры запроса
        Page<Message> page = messageService.messageList(pageable, filter);

        model.addAttribute("regions", regionsRepository.findAll());
        model.addAttribute("cities", citiesRepository.findAll());
        model.addAttribute("streets", streetsRepository.findAll());
        model.addAttribute("roadObj", roadObjectsRepository.findAll());
        model.addAttribute("models", modelOfCarRepository.findAll());
        model.addAttribute("bodies", typeOfBodyRepository.findAll());
        model.addAttribute("typeOfTransports", typeOfTransportRepository.findAll());
        model.addAttribute("brands", brandOfCarRepository.findAll());
        model.addAttribute("page", page);
        model.addAttribute("url", "/index");
        model.addAttribute("filter", filter);
        return "index";
    }

    @PostMapping("/index")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam("regNum1") String regNum1,
            @RequestParam("brandOfCar1") Long brandOfCar1,
            @RequestParam("modelOfCar1") Long modelOfCar1,
            @RequestParam("typeOfBody1") Long typeOfBody1,
            @RequestParam("typeOfTransport1") Long typeOfTransport1,
            @RequestParam("regNum2") @Nullable String regNum2,
            @RequestParam("brandOfCar2") @Nullable Long brandOfCar2,
            @RequestParam("modelOfCar2") @Nullable Long modelOfCar2,
            @RequestParam("typeOfBody2") @Nullable Long typeOfBody2,
            @RequestParam("typeOfTransport1") @Nullable Long typeOfTransport2,
            @Validated Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {

        message.setAuthor(user);
        message.setStatus(statusesRepository.findById(1L));

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);
        } else {
            fileService.saveFile(message, file);
            model.addAttribute("message", null);
            message =  messageService.buildMesaage(regNum1, brandOfCar1,
                    modelOfCar1, typeOfBody1, typeOfTransport1, regNum2, brandOfCar2, modelOfCar2, typeOfBody2,
                    typeOfTransport2, message);
            messageRepository.save(message);
        }

        model.addAttribute("message", null);

        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);

        return "redirect:/index";
    }

    @GetMapping("/user_news/{user}")
    public String userNews(
            @AuthenticationPrincipal User currentUser, //пользователь из сессии
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {

        Page<Message> page = messageRepository.findByAuthor(user, pageable);
        model.addAttribute("regions", regionsRepository.findAll());
        model.addAttribute("cities", citiesRepository.findAll());
        model.addAttribute("streets", streetsRepository.findAll());
        model.addAttribute("roadObj", roadObjectsRepository.findAll());
        model.addAttribute("models", modelOfCarRepository.findAll());
        model.addAttribute("bodies", typeOfBodyRepository.findAll());
        model.addAttribute("typeOfTransports", typeOfTransportRepository.findAll());
        model.addAttribute("brands", brandOfCarRepository.findAll());
        model.addAttribute("page", page);
        model.addAttribute("url", "user_messages" + user.getId());
        model.addAttribute("message" , message);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userNews";
    }

    @PostMapping("/user_news/{user}")
    public String updateNews(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            //@RequestParam("id") Message message,
            @RequestParam("text") String text,
            @RequestParam("tag") String tag,
            @RequestParam("regNum1") String regNum1,
            @RequestParam("brandOfCar1") Long brandOfCar1,
            @RequestParam("modelOfCar1") Long modelOfCar1,
            @RequestParam("typeOfBody1") Long typeOfBody1,
            @RequestParam("typeOfTransport1") Long typeOfTransport1,
            @RequestParam("regNum2") @Nullable String regNum2,
            @RequestParam("brandOfCar2") @Nullable Long brandOfCar2,
            @RequestParam("modelOfCar2") @Nullable Long modelOfCar2,
            @RequestParam("typeOfBody2") @Nullable Long typeOfBody2,
            @RequestParam("typeOfTransport1") @Nullable Long typeOfTransport2,
            @Validated Message message,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (message.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(text)) {
                message.setText(text);
            }

            if (!StringUtils.isEmpty(tag)) {
                message.setTag(tag);
            }

            fileService.saveFile(message, file);

            message =  messageService.buildMesaage(regNum1, brandOfCar1, modelOfCar1, typeOfBody1, typeOfTransport1,
                    regNum2, brandOfCar2, modelOfCar2, typeOfBody2,
                    typeOfTransport2, message);
            messageRepository.save(message);
        }

        return "redirect:/user_news/" + user;
    }



}
