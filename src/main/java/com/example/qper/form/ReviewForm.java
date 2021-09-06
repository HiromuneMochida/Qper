package com.example.qper.form;

import java.util.List;

import com.example.qper.common.Option;

import lombok.Data;

/**
 * レビュ―フォームクラス.
 */
@Data
public class ReviewForm {

  /** 投稿タイトル */
  private String title;

  /** 投稿内容 */
  private String content;

  /** 選択したカテゴリー */
  private String category;

  /** 画面表示するカテゴリー */
  private List<Option> categoryOptions;

  /** 削除チェックボックス */
  private String[] postId;

}
