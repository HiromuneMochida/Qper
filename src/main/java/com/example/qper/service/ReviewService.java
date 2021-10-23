package com.example.qper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qper.common.ConstantValue;
import com.example.qper.common.Util;
import com.example.qper.dto.SelectReviewDto;
import com.example.qper.entity.ReviewEntity;
import com.example.qper.form.ReviewForm;
import com.example.qper.mapper.ReviewMapper;

@Service
public class ReviewService {

  @Autowired

  private ReviewMapper mapper;
  @Autowired
  private OptionService optionService;

  /**
   * レビュ―一覧取得.
   *
   * @param entity TBL.review
   * @return レビュ―取得結果
   */
  public List<SelectReviewDto> selectReview(SelectReviewDto dto) {

    return mapper.selectReview(dto);
  }

  /**
   * レビュ―総件数取得.
   *
   * @param entity TBL.review
   * @return レビュ―総件数
   */
  public int countReview(SelectReviewDto dto) {

    return mapper.countReview(dto);
  }

  /**
   * レビュ―をpostId毎に取得する.
   *
   * @param postId
   */
  public ReviewEntity findReviewByPostId(int postId) {

    return mapper.findReviewByPostId(postId);
  }

  /**
   * レビュ―を更新する.
   *
   * @param postId
   */
  public int updeteReview(ReviewForm form) {

    return mapper.updateReview(form);
  }

  public ReviewForm entityToForm(ReviewEntity entity, ReviewForm form) {

    form.setTitle(entity.getTitle());
    form.setContent(entity.getContent());
    form.setCategory(entity.getCategoryId());
    form.setCategoryOptions(optionService.selectCategory());

    if (entity.getPrivateFlg().equals(ConstantValue.PRIVATE_FLG_ON)) {

      form.setDisp(ConstantValue.PRIVATE_FLG_TRUE);

    } else if (entity.getPrivateFlg().equals(ConstantValue.PRIVATE_FLG_OFF)) {

      form.setDisp(ConstantValue.PRIVATE_FLG_FALSE);

    }
    return form;
  }

  /**
   *  新規レビュ―登録.
   *
   * @param entity TBL.review
   */
  public void insertReview(ReviewForm form) {
    //ReviewEntityを生成する
    ReviewEntity entity = new ReviewEntity();
    //フォームからエンティティに詰めなおす
    entity.setTitle(form.getTitle());
    entity.setContent(form.getContent());
    entity.setEmail(Util.getUserEmail());
    entity.setCategoryId(form.getCategory());

    if (form.isDisp()) {
      //チェックが付いている場合
      entity.setPrivateFlg(ConstantValue.PRIVATE_FLG_ON);
    } else {
      //チェックが付いていない場合
      entity.setPrivateFlg(ConstantValue.PRIVATE_FLG_OFF);
    }

    mapper.insertReview(entity);
  }

  /**
   *  レビュ―削除.
   *
   * @param entity TBL.review
   */
  public void deleteReview(ReviewForm form) {
    if (form.getDeleteId() != null) {
      for (String postId : form.getDeleteId()) {

        mapper.deleteReview(postId);
      }
    }

  }
}
