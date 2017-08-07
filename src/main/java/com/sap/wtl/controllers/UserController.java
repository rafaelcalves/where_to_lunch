package com.sap.wtl.controllers;

import com.sap.wtl.models.User;
import com.sap.wtl.services.UserService;
import com.sap.wtl.validator.UserValidator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Resource
    private UserService defaultUserService;

    @Resource
    private UserValidator userValidator;

    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User userForm, @Valid User user, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        defaultUserService.saveOrUpdateUser(user);
        return "redirect:/user/add";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "user/login";
    }
}
