package com.example.qper.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SelectReviewDto {

  /** 投稿ID */
  private Integer postId;

  /** 投稿タイトル */
  private String title;

  /** 投稿内容 */
  private String content;

  /** 投稿者のメールアドレス */
  private String email;

  /** フラグ(公開/非公開) */
  private String privateFlg;

  /** 作成日時 */
  private Date createdAt;

  /** カテゴリー名 */
  private String categoryName;

  /** フラグ(削除) */
  private String delFlg;

  /** 取得下限値 */
  private int lowerLimit;

  /** 取得上限値 */
  private int upperLimit;
}
