package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.EstablishmentView;
import com.sap.wtl.models.User;
import com.sap.wtl.models.Poll;
import com.sap.wtl.services.EstablishmentService;
import com.sap.wtl.services.VoteService;
import com.sap.wtl.services.PollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/poll")
public class PollController {
    @Resource
    private PollService defaultPollService;

    @Resource
    private EstablishmentService defaultEstablishmentService;

    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("poll", new Poll());
        return "poll/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid Poll poll, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "poll/register";
        }
        defaultPollService.create(poll);
        return "redirect:/poll/history";
    }

    @RequestMapping(value = "/list/{pollId}")
    public String listEstablishments(@PathVariable("pollId") int pollId, Model model) {
        List<EstablishmentView> establishments = defaultPollService.listOrderedEstablishmentsAll(pollId);
        model.addAttribute("establishments", establishments);
        model.addAttribute("pollId",pollId);
        return "poll/list";
    }

    @RequestMapping(value = "/history")
    public String listAll(Model model) {
        List<Poll> polls = defaultPollService.listHistory();
        model.addAttribute("polls", polls);
        return "poll/history";
    }

    @RequestMapping(value = "/votedUsers/{pollId}/{establishmentId}")
    public String votedUsers(@PathVariable("pollId") int pollId,@PathVariable("establishmentId") int establishmentId, Model model) {

        List<User> users = defaultPollService.listVotedUsers(pollId,establishmentId);
        model.addAttribute("users", users);
        model.addAttribute("poll", defaultPollService.findById(pollId));
        return "poll/users";
    }

    @RequestMapping(value = "/votedEstablishments/{id}")
    public String votedEstablishments(@PathVariable("id") int pollId, Model model) {
        List<EstablishmentView> establishments = defaultPollService.listOrderedEstablishmentsVoted(pollId);
        model.addAttribute("establishments", establishments);
        model.addAttribute("poll", defaultPollService.findById(pollId));
        return "poll/voted_establishments";
    }

    @RequestMapping(value = "/finish/{id}")
    public String finish(@PathVariable("id") int pollId){
        Poll finishedPoll = defaultPollService.findById(pollId);
        finishedPoll.setChosenEstablishment(defaultPollService.getMostVotedEstablishment(pollId));
        defaultPollService.edit(finishedPoll);
        return "redirect:/poll/history";
    }
}
