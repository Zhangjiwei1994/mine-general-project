package com.hongm.controller;

import com.hongm.pojo.User;
import com.hongm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "member-list";
    }

    @PostMapping("/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        boolean userExists = userService.isUserExists(username, password);
        if (userExists) {
            session.setAttribute("user", username);
            return "index";
        } else {
            return "login";
        }
    }

//    @RequestMapping("/logout")
//    public String userLogout(@PathVariable("username") String username) {
//        System.out.println(username);
//        return "login";
//    }

    @GetMapping(value = "/logout")
    public String userLogout(@RequestParam String username, HttpSession session) {
        if (session.getAttribute("user") != null && username.equals(session.getAttribute("user").toString())) {
            session.removeAttribute("user");
        }
        return "login";
    }
}
