package com.example.qper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.qper.entity.ReviewEntity;
import com.example.qper.form.ReviewForm;
import com.example.qper.service.OptionService;
import com.example.qper.service.ReviewService;

/**
 * レビュ―.
 */
@Controller
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @Autowired
  private OptionService optionService;


  @RequestMapping(value = "/t", method = RequestMethod.GET)
  public String t(ReviewEntity entity, Model model) {


    return "NewFile";
  }
  /**
   * レビュ―一覧画面初期表示.
   *
   * @param entity TBL.review
   * @param model
   * @return reviewList.html
   */
  @RequestMapping(value = "/review/getReviewList", method = RequestMethod.GET)
  public String getReviewList(ReviewEntity entity, Model model) {

    List<ReviewEntity> selectEntiyList = reviewService.selectReview(entity);

    model.addAttribute("selectEntiyList", selectEntiyList);

    return "reviewList";
  }

  /**
   * レビュ―登録画面初期表示.
   *
   * @param form レビュ―フォーム
   * @param model
   * @return reviewRegist.html
   */
  @RequestMapping(value = "/review/getReviewRegist", method = RequestMethod.GET)
  public String getReviewRegist(ReviewForm form, Model model) {

    model.addAttribute("reviewForm", optionService.initializeReviewForm());

    return "reviewRegist";
  }

  /**
   * レビュ―登録処理.
   *
   * @param form レビュ―フォーム
   * @param model
   * @return reviewList.html
   */
  @RequestMapping(value = "/review/postReviewRegist", method = RequestMethod.POST)
  public String postReviewRegist(ReviewForm form, Model model) {

    reviewService.insertReview(form);

    return "redirect:/review/getReviewList";
  }
}
