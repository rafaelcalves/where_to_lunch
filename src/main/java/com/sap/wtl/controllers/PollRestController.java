package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.EstablishmentView;
import com.sap.wtl.services.PollService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PollRestController {

    @Resource
    private PollService defaultPollService;

    @RequestMapping(value="/list/{id}/{filter}", method = RequestMethod.GET)
    public List<EstablishmentView> jsonEstablishemtFiltered(@PathVariable("id") int pollId, @PathVariable("filter") String filter){
        return defaultPollService.listOrderedEstablishmentsFiltered(pollId,false,filter);
    }

    @RequestMapping(value="/list/{id}/", method = RequestMethod.GET)
    public List<EstablishmentView> jsonEstablishments(@PathVariable("id") int pollId){
        return defaultPollService.listOrderedEstablishmentsFiltered(pollId,false,"");
    }
}
