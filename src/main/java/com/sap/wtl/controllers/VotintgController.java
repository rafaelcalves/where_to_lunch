package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Voting;
import com.sap.wtl.services.EstablishmentService;
import com.sap.wtl.services.VotingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/voting")
public class VotintgController {
    @Resource
    private VotingService defaultVotingService;

    @Resource
    private EstablishmentService defaultEstablishmentService;

    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("voting", new Voting());
        return "voting/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("voting") Voting votingForm, @Valid Voting voting, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "voting/register";
        }
        defaultVotingService.create(voting);
        return "redirect:/voting/add";
    }

    @RequestMapping(value = "/")
    public String list(Model model) {
        List<Establishment> establishments = defaultEstablishmentService.listEstablishments();
        model.addAttribute("establishments", establishments);
        return "voting/list";
    }
}
