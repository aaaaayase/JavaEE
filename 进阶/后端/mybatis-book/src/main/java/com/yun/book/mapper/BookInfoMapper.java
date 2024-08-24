package com.yun.book.mapper;

import com.yun.book.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Select("select *from book_info where status!=0 order by id desc limit #{offsetPage},#{pageSize}")
    public List<BookInfo> getListByPage(Integer offsetPage, Integer pageSize);

    @Select("select count(1) from book_info where status!=0")
    public Integer getCount();

    @Insert("insert into book_info(book_name,author,count,price,publish,`status`) values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    public Integer insert(BookInfo bookInfo);
    
    @Select("select * from book_info where status!=0 and id=#{bookId};")
    public BookInfo getBookInfo(Integer bookId);

    Integer updateBook(BookInfo bookInfo);

    Integer deleteBatch(List<Integer> ids);
}
