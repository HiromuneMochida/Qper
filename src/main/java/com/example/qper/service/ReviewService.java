package com.example.qper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qper.common.ConstantValue;
import com.example.qper.common.Util;
import com.example.qper.entity.ReviewEntity;
import com.example.qper.form.ReviewForm;
import com.example.qper.mapper.ReviewMapper;

@Service
public class ReviewService {

  @Autowired
  private ReviewMapper mapper;

  /**
   * レビュ―一覧取得.
   *
   * @param entity TBL.review
   * @return レビュ―取得結果
   */
  public List<ReviewEntity> selectReview(ReviewEntity entity) {

    return mapper.selectReview(entity);
  }

  /**
   * 新規レビュ―ー投稿.
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
}
