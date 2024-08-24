package com.yun.book.controller;

import com.yun.book.constant.Constants;
import com.yun.book.enums.ResultCodeEnum;
import com.yun.book.model.*;
import com.yun.book.service.BookInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookInfoController {

    @Autowired
    BookInfoService service;

    @RequestMapping("/insert")
    public boolean insert(BookInfo bookInfo) {
        log.info("BookController.insert 接收参数:{}", bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName()) || !StringUtils.hasLength(bookInfo.getAuthor()) || bookInfo.getCount() == null || bookInfo.getPrice() == null || !StringUtils.hasLength(bookInfo.getPublish())) {
            log.warn("参数不正确");
            return false;
        }

        Integer ret = service.insert(bookInfo);
        if (ret == 0) {
            log.error("添加图书失败");
            return false;
        }
        log.info("添加图书成功");
        return true;
    }

    @RequestMapping("/getListByPage")
    public Result<PageResult<BookInfo>> getListByPage(RequestPage requestPage, HttpSession session) {
        log.info("getListByPage, 接收参数: {}", requestPage);
        PageResult<BookInfo> list = service.getList(requestPage);
        return Result.success(list);
    }

    @RequestMapping("/getBookInfo")
    public BookInfo getBookInfo(Integer bookId) {

        log.info("BookInfoContoller, bookId: {}", bookId);
        BookInfo bookInfo = service.getBookInfo(bookId);
        if (bookInfo == null) {
            return new BookInfo();
        } else {
            return bookInfo;
        }
    }

    @RequestMapping("/updateBook")
    public boolean updateBook(BookInfo bookInfo) {
        log.info("updateBook, bookInfo: {}", bookInfo);
        if (bookInfo.getId() == null) {
            log.warn("ID不能为空！！！");
            return false;
        }
        if (bookInfo.getBookName() != null && "".equals(bookInfo.getBookName().trim())) {
            log.warn("想要修改为的图书名称不能为空！！！");
            return false;
        }

        Integer result = service.updateBook(bookInfo);
        if (result > 0) {
            return true;
        }

        return false;
    }

    @RequestMapping("/deleteBatch")
    public boolean deleteBatch(@RequestParam List<Integer> ids) {
        log.info("deleteBatch, ids: {}", ids);
        if (ids == null || ids.size() == 0) {
            return true;
        }

        Integer result = service.deleteBatch(ids);
        if (result > 0) {
            return true;
        }

        return false;
    }

}
