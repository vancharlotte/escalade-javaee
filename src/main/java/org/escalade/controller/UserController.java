package org.escalade.controller;

import org.escalade.controller.validator.UserFormValidator;
import org.escalade.model.dao.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = "/user")
public class UserController  extends HttpServlet {

    UserDaoImpl userDao;
    public void init() {
        userDao = new UserDaoImpl();
    }


    UserFormValidator validator;

    static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

 /*   @GetMapping(value = "/register")
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
