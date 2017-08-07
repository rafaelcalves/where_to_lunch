package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
}
