package com.example.qper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qper.common.Option;
import com.example.qper.form.ReviewForm;
import com.example.qper.mapper.OptionMapper;

@Service
public class OptionService {

  @Autowired
  private OptionMapper mapper;

  /**
   * カテゴリー情報をセレクトボックスに格納する.
   *
   * @return レビュ―フォーム
   */
  public ReviewForm initializeReviewForm() {

    //レビュ―フォームを生成
    ReviewForm form = new ReviewForm();
    //取得したカテゴリーの情報を格納する
    form.setCategoryOptions(mapper.selectCategory());

    return form;
  }

  public List<Option> selectCategory() {


    return mapper.selectCategory();
  }

}
