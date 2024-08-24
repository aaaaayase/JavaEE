package com.yun.book.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {

    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private String statusCN;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
