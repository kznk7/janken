package oit.is.z1438.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1438.kaizi.janken.model.Janken;
import oit.is.z1438.kaizi.janken.model.Entry;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  @Autowired
  private Entry entry;

  @GetMapping
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("entry", this.entry);
    return "lec02.html";
  }

  @PostMapping
  public String lec02(@RequestParam String user_name, ModelMap model) {
    model.addAttribute("user_name", user_name);
    return "lec02.html";
  }

  @GetMapping("game")
  public String game(@RequestParam Integer user_hand, ModelMap model) {
    Janken janken = new Janken(user_hand);
    model.addAttribute("user_hand", janken.getUserHand());
    model.addAttribute("cpu_hand", janken.getCpuHand());
    model.addAttribute("result", janken.result());
    return "lec02.html";
  }

}
