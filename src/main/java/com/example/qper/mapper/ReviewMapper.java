package com.example.qper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.qper.entity.ReviewEntity;
/**
 * レビュ―マッパー.
 */
@Mapper
public interface ReviewMapper {

  /** レビュ―一覧取得 */
  public List<ReviewEntity> selectReview(ReviewEntity entity);
}
