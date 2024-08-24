package com.yun.book.service;

import com.yun.book.enums.StatusEnum;
import com.yun.book.mapper.BookInfoMapper;
import com.yun.book.model.BookInfo;
import com.yun.book.model.PageResult;
import com.yun.book.model.RequestPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoService {

    @Autowired
    BookInfoMapper mapper;

    public Integer insert(BookInfo bookInfo) {
        return mapper.insert(bookInfo);
    }

    public PageResult getList(RequestPage requestPage) {
        Integer offset = requestPage.getOffsetPage();
        Integer pageSize = requestPage.getPageSize();
        Integer count = mapper.getCount();
        List<BookInfo> bookInfos = mapper.getListByPage(offset, pageSize);

        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(StatusEnum.getNameByCode(bookInfo.getStatus()).getName());
        }

        PageResult<BookInfo> result = new PageResult<>();
        result.setCount(count);
        result.setItems(bookInfos);
        result.setRequestPage(requestPage);

        return result;
    }

    public BookInfo getBookInfo(Integer bookId) {

        return mapper.getBookInfo(bookId);
    }

    public Integer updateBook(BookInfo bookInfo) {

        return mapper.updateBook(bookInfo);
    }

    public Integer deleteBatch(List<Integer> ids) {
        return mapper.deleteBatch(ids);
    }
}
