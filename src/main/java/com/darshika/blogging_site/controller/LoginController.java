package com.darshika.blogging_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {

    if (username.equals("demoUser") && password.equals("password")) {
      return "redirect:/blogs/dashboard";
    } else {
      model.addAttribute("error", "Invalid username or password");
      return "login";
    }
  }
}
