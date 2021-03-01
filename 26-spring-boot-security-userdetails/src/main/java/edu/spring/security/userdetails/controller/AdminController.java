package edu.spring.security.userdetails.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
@Secured( value = { "ROLE_ADMIN" })
public class AdminController {

    @ResponseBody
    @RequestMapping("/posts/create")
    public String createPost(){

        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" +  userDetails.getUsername()
                + ", auth: " + userDetails.getAuthorities().toString()
                + " wants create posts...\n" + "</body>\n" + "</html>";
    }

}
