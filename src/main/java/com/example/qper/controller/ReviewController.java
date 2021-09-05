package com.example.qper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.qper.entity.ReviewEntity;
import com.example.qper.service.ReviewService;
/**
 * レビュ―.
 */
@Controller
public class ReviewController {

  @Autowired
  private ReviewService service;

  /**
   * レビュ―一覧初期表示.
   *
   * @param entity
   * @param model
   * @return reviewList.html
   */
  @RequestMapping(value = "/review/list", method = RequestMethod.GET)
  public String init(ReviewEntity entity, Model model) {

    List<ReviewEntity> selectEntiyList = service.selectReview(entity);

    model.addAttribute("selectEntiyList", selectEntiyList);

    return "reviewList";
  }
}
