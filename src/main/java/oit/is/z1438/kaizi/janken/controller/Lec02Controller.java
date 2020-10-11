package oit.is.z1438.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1438.kaizi.janken.model.Janken;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  @PostMapping
  public String lec02(@RequestParam String user_name, ModelMap model) {
    model.addAttribute("user_name", user_name);
    return "lec02.html";
  }

  @GetMapping
  public String lec02(@RequestParam Integer user_hand, ModelMap model) {
    Janken janken = new Janken(user_hand);
    model.addAttribute("user_hand", janken.getUserHand());
    model.addAttribute("cpu_hand", janken.getCpuHand());
    model.addAttribute("result", janken.result());
    return "lec02.html";
  }
}
