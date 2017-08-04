package com.sap.wtl.controllers;

import com.sap.wtl.daos.UserDao;
import com.sap.wtl.models.User;
import com.sap.wtl.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService defaultUserService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(WebRequest request, Model model) {
        User userDto = new User();
        model.addAttribute("user", userDto);
        return "user/registration";
    }

    @RequestMapping(value = "/add")
    public String add(User user, Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "user/registration";
        }
        defaultUserService.createUpdateUser(user);
        return "redirect:/user/";
    }
}
