package com.example.qper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 認証クラス.
 */
@Controller
public class AuthController {

  /** ログイン画面表示. */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String init() {

    return "login";
  }

  /** ログイン処理. */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login() {

    return "redirect:/home";
  }

  /** ログアウト処理. */
  @RequestMapping(value = "/logout", method = RequestMethod.POST)
  public String logout() {

    return "redirect:/login";
  }

  /** ログイン完了処理.
   *
   * @param Model
   */
  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home(Model model) {

    return "home";
  }
}
