package com.example.qper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.qper.entity.ReviewEntity;
import com.example.qper.form.ReviewForm;

/**
 * レビュ―マッパー.
 */
@Mapper
public interface ReviewMapper {

  /**
   * レビュ―一覧取得.
   *
   * @param entity TBL.review
   * @return 取得結果
   */
  public List<ReviewEntity> selectReview(ReviewEntity entity);

  /**
   *  新規レビュ―登録.
   *
   * @param entity TBL.review
   */
  public void insertReview(ReviewEntity entity);

  /**
   * レビュ―総件数取得.
   *
   * @param entity TBL.review
   */
  public int countReview(ReviewEntity entity);

  /**
   * レビュ―をpostId毎に取得する.
   *
   * @param postId
   */
  public ReviewEntity findReviewByPostId(int postId);

  /**
   * レビュ―を更新する.
   *
   * @param レビュ―フォーム
   */
  public int updateReview(ReviewForm form);

  /**
   * レビュ―を削除する.
   *
   * @param postId
   */
  public void deleteReview(String postId);
}
