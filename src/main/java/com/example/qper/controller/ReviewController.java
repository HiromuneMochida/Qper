package com.example.qper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.qper.common.ConstantValue;
import com.example.qper.common.Pagination;
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

  /**
   * レビュ―一覧画面初期表示.
   *
   * @param entity TBL.review
   * @param model
   * @return reviewList.html
   */
  @RequestMapping(value = "/review/getReviewList", method = RequestMethod.GET)
  public String getReviewList(ReviewEntity entity, Model model) {

    //1ページの表示下限値
    entity.setLowerLimit(ConstantValue.PAGE_LIMIT_ZERO);
    //1ページの表示上限値
    entity.setUpperLimit(ConstantValue.PAGE_LIMIT);

    Pagination<ReviewEntity> selectReview = new Pagination<ReviewEntity>(reviewService.countReview(entity), ConstantValue.PAGE_LIMIT);

    selectReview.moveTo(ConstantValue.PAGE_START);
    //取得結果を格納する
    selectReview.setEntities(reviewService.selectReview(entity));

    model.addAttribute("selectReview", selectReview);

    return "reviewList";
  }

  /**
   * レビュ―一覧画面切替表示.
   *
   * @param entity TBL.review
   * @param pageNo
   * @param model
   * @return reviewList.html
   */
  @RequestMapping(value = "/review/getReviewPageView", method = RequestMethod.GET)
  public String getReviewPageView(@RequestParam("pageNo") int pageNo, ReviewEntity entity, Model model) {

    Pagination<ReviewEntity> selectReview = new Pagination<ReviewEntity>(reviewService.countReview(entity), ConstantValue.PAGE_LIMIT);

    selectReview.moveTo(pageNo);

    //1ページの表示下限値
    entity.setLowerLimit((pageNo - 1) * ConstantValue.PAGE_LIMIT);
    //1ページの表示上限値
    entity.setUpperLimit(ConstantValue.PAGE_LIMIT);
    //再取得結果を格納する
    selectReview.setEntities(reviewService.selectReview(entity));

    model.addAttribute("selectReview", selectReview);

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
