package com.example.qper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.qper.entity.ReviewEntity;

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
   * 新規レビュ―ー投稿.
   *
   * @param entity TBL.review
   */
  public void insertReview(ReviewEntity entity);
}
