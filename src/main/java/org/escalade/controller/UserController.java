package org.escalade.controller;

import org.escalade.controller.validator.UserFormValidator;
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

import javax.validation.Valid;


@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserFormValidator validator;

    static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("user/addUser", "user", new User());

    }


    @PostMapping(value = "/register")
    public String newUser(@Valid @ModelAttribute("user") @Validated User user,
                          BindingResult result, ModelMap model) {
        validator.validate(user, result);
        if (result.hasErrors()) {
            return "user/addUser";
        } else {
            userService.save(user);
            model.addAttribute("userId", user.getUserId());
            return "redirect:/user/{userId}";
        }
    }

    @GetMapping("/user/{userId}")
    public ModelAndView one(@SessionAttribute("user") User user) {
        ModelAndView mav = new ModelAndView("user/page","userPage", user);
        mav.addObject("message", "bienvenue " + user.getUsername());
        return mav;
    }


    @GetMapping(value = "/modifyUser")
    public ModelAndView modifyUser(@SessionAttribute("user") User user) {
        return new ModelAndView("user/addUser", "user", user);

    }

/*
    @PutMapping("/user/{userId}")
    User updateUser(@RequestBody User newUser, @PathVariable int id) {
        User user = userService.findById(id);
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());
        return userService.update(user);
    }

    @DeleteMapping("/user/{userId}")
    void deleteEmployee(@PathVariable int id) {
        userService.deleteById(id);
    }*/


}
