package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.services.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    private SecurityService defaultSecurityService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("userName",defaultSecurityService.findLoggedInUsername());
        return "redirect: poll/";
    }
}
