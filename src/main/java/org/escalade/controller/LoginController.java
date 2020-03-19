package org.escalade.controller;

import org.escalade.model.entity.User;
import org.escalade.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UserService userService;


    static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/")
    public ModelAndView test() {
        return new ModelAndView("index", "user", new User());
    }


}
