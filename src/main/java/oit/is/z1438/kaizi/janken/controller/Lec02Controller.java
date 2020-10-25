package oit.is.z1438.kaizi.janken.controller;

import java.util.ArrayList;
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
import oit.is.z1438.kaizi.janken.model.UserMapper;
import oit.is.z1438.kaizi.janken.model.MatchMapper;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry entry;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @GetMapping("/lec02")
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("entry", this.entry);
    model.addAttribute("users", userMapper.selectAllUsers());
    model.addAttribute("matches", matchMapper.selectAllMatches());
    return "lec02.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, Principal prin, ModelMap model) {
    model.addAttribute("user_name", prin.getName());
    model.addAttribute("cpu_name", userMapper.selectAllUsers().get(id - 1).getName());
    return "match.html";
  }

  @GetMapping("/result")
  public String result(@RequestParam Integer user_hand, ModelMap model) {
    Janken janken = new Janken(user_hand);
    model.addAttribute("user_hand", janken.getUserHand());
    model.addAttribute("cpu_hand", janken.getCpuHand());
    model.addAttribute("result", janken.result());
    return "lec02.html";
  }

}
