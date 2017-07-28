package com.sap.wtl.controllers;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.services.EstablishmentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/establishment")
public class EstablishmentController {

    @Resource
    private EstablishmentService defaultEstablishmentService;

    @RequestMapping(value = "/")
    public String list(Model model) {
        List<Establishment> establishments = defaultEstablishmentService.listEstablishments();
        model.addAttribute("establishments", establishments);
        return "establishment/list";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("establishment", new Establishment());
        return "establishment/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid Establishment establishment, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("establishment", establishment);
            return "establishment/register";
        }
        defaultEstablishmentService.createUpdateEstablishment(establishment);
        return "redirect:/establishment/";
    }

    @RequestMapping(value = "/remove/{id}")
    public String remove(@PathVariable("id") int removeId) {

        defaultEstablishmentService.deleteEstablishment(removeId);
        return "redirect:/establishment/";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int editId, Model model) {
        model.addAttribute("establishment", defaultEstablishmentService.getEstablishment(editId));
        return "establishment/register";
    }

}
