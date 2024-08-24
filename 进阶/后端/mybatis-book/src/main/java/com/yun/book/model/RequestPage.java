package com.yun.book.model;

import lombok.Data;

@Data
public class RequestPage {

    private Integer currentPage = 1;
    private Integer pageSize = 10;

    public Integer getOffsetPage() {
        return (currentPage - 1) * pageSize;
    }

}
