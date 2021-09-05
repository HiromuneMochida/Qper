package com.example.qper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qper.entity.ReviewEntity;
import com.example.qper.mapper.ReviewMapper;

@Service
public class ReviewService {

  @Autowired
  private ReviewMapper mapper;

  /**
   * レビュ―一覧取得.
   *
   * @param entity
   * @return レビュ―取得結果
   */
  public List<ReviewEntity> selectReview(ReviewEntity entity) {

    return mapper.selectReview(entity);
  }
}
