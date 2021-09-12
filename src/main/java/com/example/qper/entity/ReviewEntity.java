package com.example.qper.entity;

import java.util.Date;

import lombok.Data;

/**
 * TBL.review
 */
@Data
public class ReviewEntity {

  /** 投稿ID */
  private Integer postId;

  /** 投稿タイトル */
  private String title;

  /** 投稿内容 */
  private String content;

  /** 投稿者のメールアドレス */
  private String email;

  /** カテゴリーTBLと紐づくID */
  private String categoryId;

  /** 作成日時 */
  private Date createdAt;

  /** フラグ(削除) */
  private String delFlg;

  /** フラグ(公開/非公開) */
  private String privateFlg;

  /** TBL.category */
  private CategoryEntity categoryEntity;
}
