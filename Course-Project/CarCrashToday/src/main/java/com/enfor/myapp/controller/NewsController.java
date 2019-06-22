package com.enfor.myapp.controller;

import com.enfor.myapp.entity.Message;
import com.enfor.myapp.entity.User;
import com.enfor.myapp.repository.CitiesRepository;
import com.enfor.myapp.repository.MessageRepository;
import com.enfor.myapp.repository.RegionsRepository;
import com.enfor.myapp.repository.StreetsRepository;
import com.enfor.myapp.service.FileService;
import com.enfor.myapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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
    private RegionsRepository regionsRepository;

    @Autowired
    private CitiesRepository citiesRepository;

    @Autowired
    private StreetsRepository streetsRepository;



    @GetMapping("/index")
    public String index(@RequestParam(required = false, defaultValue = "") String filter,
                        Model model,
                        @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {    //параметры запроса
        Page<Message> page = messageService.messageList(pageable, filter);

        model.addAttribute("regions", regionsRepository.findAll());
        model.addAttribute("cities", citiesRepository.findAll());
        model.addAttribute("streets", streetsRepository.findAll());
        model.addAttribute("page", page);
        model.addAttribute("url", "/index");
        model.addAttribute("filter", filter);
        return "index";
    }

    @PostMapping("/index")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {

        message.setAuthor(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);
        } else {
            fileService.saveFile(message, file);
            model.addAttribute("message", null);
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
            @RequestParam("id") Message message,
            @RequestParam("text") String text,
            @RequestParam("tag") String tag,
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

            messageRepository.save(message);
        }

        return "redirect:/user_news/" + user;
    }



}
