package com.example.qper.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * TBL.category
 */
@Data
public class CategoryEntity implements Serializable {

  /** カテゴリーID */
  private String categoryId;

  /** カテゴリー名 */
  private String categoryName;

}
