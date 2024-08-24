package com.yun.book.mapper;

import com.yun.book.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookInfoMapperTest {

    @Autowired
    BookInfoMapper mapper;



    @Test
    void insert() {
        BookInfo bookInfo=new BookInfo();
        bookInfo.setBookName("aaa");
        bookInfo.setCount(1242);
        bookInfo.setPublish("bbb");
        bookInfo.setAuthor("dcy");
        bookInfo.setPrice(new BigDecimal("2123.22"));
        System.out.println(mapper.insert(bookInfo));
    }
}