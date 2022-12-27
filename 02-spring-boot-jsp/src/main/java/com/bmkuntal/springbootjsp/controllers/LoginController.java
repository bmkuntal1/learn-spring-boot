package com.bmkuntal.springbootjsp.controllers;

import com.bmkuntal.springbootjsp.models.LoginModel;
import com.bmkuntal.springbootjsp.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, ModelMap model) {
        logger.info("Login:Request Body email:{} password:{}", email, password);
        if (loginService.login(new LoginModel(email, password))) {
            return "todo-list";
        }
        else {
            model.put("error", "invalid email or password");
            return "login";
        }
    }
}
