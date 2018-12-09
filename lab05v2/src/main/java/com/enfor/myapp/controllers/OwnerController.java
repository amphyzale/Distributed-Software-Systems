package com.enfor.myapp.controllers;

import com.enfor.myapp.model.Owner;
import com.enfor.myapp.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OwnerController {
    private OwnerService ownerService;

    @Autowired(required = true)
    @Qualifier(value = "ownerService")
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = "owners", method = RequestMethod.GET)
    public String listOwners(Model model){
        model.addAttribute("owner", new Owner());
        model.addAttribute("listOwners", this.ownerService.listAllOwners());

        return "owners";
    }

    @RequestMapping(value = "/owners/add", method = RequestMethod.POST)
    public String addOwner(@ModelAttribute("owner") Owner owner){
        if(owner.getId() == 0){
            this.ownerService.addOwner(owner);
        }else {
            this.ownerService.updateOwner(owner);
        }

        return "redirect:/owners";
    }

    @RequestMapping("/remove/{id}")
    public String removeOwner(@PathVariable("id") int id){
        this.ownerService.deleteOwner(id);

        return "redirect:/owners";
    }

    @RequestMapping("edit/{id}")
    public String editOwner(@PathVariable("id") int id, Model model){
        model.addAttribute("owner", this.ownerService.getOwnerById(id));
        model.addAttribute("listOwners", this.ownerService.listAllOwners());

        return "owners";
    }

    @RequestMapping("ownerdata/{id}")
    public String ownerData(@PathVariable("id") int id, Model model){
        model.addAttribute("owner", this.ownerService.getOwnerById(id));

        return "ownerdata";
    }
}
