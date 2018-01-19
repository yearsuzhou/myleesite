package com.suzhou.myleesite.modules.sys.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:suzhou
 * @Date: 2018-01-19
 * @Time: 下午 3:47
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        return "modules/sys/login";
    }
}
