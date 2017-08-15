package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.User;
import com.sap.wtl.models.Vote;
import com.sap.wtl.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value="/vote")
public class VoteController {
    @Resource
    private VoteService defaultVoteService;

    @Resource
    private PollService defaultPollService;

    @Resource
    private EstablishmentService defaultEstablishmentService;

    @Resource
    private UserService defaultUserService;

    @Resource
    private SecurityService defaultSecurityService;

    @RequestMapping(value = "/add/{pollId}/{establishmentId}")
    public String edit(@PathVariable("pollId") int pollId, @PathVariable("establishmentId") int establishmentId, Model model) {
        User user = defaultUserService.findByEmail(defaultSecurityService.findLoggedInUsername());

        Vote vote = defaultVoteService.findByUserId(pollId,user.getId());
        if(vote == null){
            vote = new Vote();
            vote.setEstablishment(defaultEstablishmentService.getEstablishment(establishmentId));
            vote.setUser(user);
            vote.setPoll(defaultPollService.findById(pollId));
        }else{
            vote.setEstablishment(defaultEstablishmentService.getEstablishment(establishmentId));
            vote.setEdited(true);
        }
        vote.setLastEdit(LocalDateTime.now());

        defaultVoteService.createEdit(vote);

        return "redirect: /poll/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid Vote vote, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("vote", vote);
            model.addAttribute("userName",defaultSecurityService.findLoggedInUsername());
            return "poll/list";
        }
        defaultVoteService.createEdit(vote);
        return "redirect:/";
    }

    @RequestMapping(value = "/remove/{userId}/{vontingId}")
    public String remove(@PathVariable("userId") int userId, @PathVariable("vontingId") int vontingId) {

        defaultVoteService.delete(defaultVoteService.findByUserId(vontingId,userId));
        return "redirect:/poll/votedUsers/" + vontingId;
    }
}
