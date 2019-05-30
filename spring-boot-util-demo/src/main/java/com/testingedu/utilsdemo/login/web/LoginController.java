package com.testingedu.utilsdemo.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
public class LoginController {

    @RequestMapping("/login2")
    public String index2() {
        return "login2";
    }

    @RequestMapping("/login")
    public String index1() {
        return "login";
    }

    @RequestMapping(value = "/{target}", method = RequestMethod.GET)
    public ModelAndView getTarget(@PathVariable String target, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(36000);
        return new ModelAndView(target);
    }
}
