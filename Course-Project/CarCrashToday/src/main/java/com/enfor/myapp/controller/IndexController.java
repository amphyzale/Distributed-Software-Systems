package com.enfor.myapp.controller;

import com.enfor.myapp.entity.Message;
import com.enfor.myapp.entity.User;
import com.enfor.myapp.repository.MessageRepository;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/index")
    public String index(@RequestParam(required = false, defaultValue = "") String filter,
                        Model model,
                        @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {    //параметры запроса
        Page<Message> page = messageService.messageList(pageable, filter);

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


}
