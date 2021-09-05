package com.example.qper.form;

import lombok.Data;
/**
 * レビュ―フォームクラス.
 */
@Data
public class ReviewForm {

  /** 投稿内容 */
  String content;

  /** 削除チェックボックス */
  String[] postId;

}
