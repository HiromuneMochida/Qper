package com.example.qper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.qper.common.Option;

@Mapper
public interface OptionMapper {

  /** カテゴリー取得. */
  public List<Option> selectCategory();
}
