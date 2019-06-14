package com.enfor.myapp.controller;


import com.enfor.myapp.entity.Message;
import com.enfor.myapp.entity.User;
import com.enfor.myapp.repository.MessageRepository;
import com.enfor.myapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/user_news/{user}")
public class NewsController {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private FileService fileService;

    @GetMapping
    public String userNews(
            @AuthenticationPrincipal User currentUser, //пользователь из сессии
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {

        Page<Message> page = messageRepository.findByAuthor(user, pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/index");
        model.addAttribute("message" , message);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userNews";
    }

    @PostMapping
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
