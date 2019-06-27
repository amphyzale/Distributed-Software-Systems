package com.enfor.myapp.controller;

import com.enfor.myapp.repository.StatusesRepository;
import com.enfor.myapp.service.DiagramService;
import com.enfor.myapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private StatusesRepository statusesRepository;

    @Autowired
    private DiagramService diagramService;

    @GetMapping("/")
    public String greeting(
            Model model) {

        Map<String, Integer> map = diagramService.getCrashMap(messageService.getAllPublichedMessage(statusesRepository.findById(3L)));

        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            model.addAttribute("month" + i, entry.getKey());
            model.addAttribute("count" + i, entry.getValue());
            i++;
        }
        model.addAttribute("map", map);

        model.addAttribute("messages", messageService.getAllPublichedMessage(statusesRepository.findById(3L)));

        return "greeting";
    }

}
