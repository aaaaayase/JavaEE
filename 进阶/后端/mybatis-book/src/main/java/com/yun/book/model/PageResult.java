package com.yun.book.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private List<T> items;
    private Integer count;
    private RequestPage requestPage;

}
