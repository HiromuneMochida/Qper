package com.example.qper.common;

import java.util.List;

import lombok.Data;

@Data
public class Pagination<E> {

  private int pageFrom;

  private int pageTo;

  /** 現在のページ */
  private int currentPage;

  /** 1ページあたりの表示件数 */
  private int recordPerPage;

  /** データの総件数 */
  private int totalRecordCount;

  /** ページの総件数 */
  private int totalPageCount;

  /** 汎用的に結果を格納する */
  private List<E> entities;

  public Pagination(int totalRecordCount, int recordPerPage) {

    this.totalRecordCount = totalRecordCount;
    this.recordPerPage = recordPerPage;
    //ページの総件数 = データの総件数 / 1ページあたりの表示件数
    this.totalPageCount = (this.totalRecordCount / this.recordPerPage) + (this.totalRecordCount % this.recordPerPage > 0 ? 1 : 0);

  }

  public void moveTo(int page) {
    this.currentPage = page;
    this.pageFrom = Math.max(page - 1, 2);
    this.pageTo = Math.min(page + 2, totalPageCount - 1);
    this.pageFrom = Math.max(this.pageTo - 2, 2);
  }

}
