package com.yun.blog.mapper;

import com.yun.blog.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogInfoMapper {

    @Select("select id,title,content,user_id,update_time from blog where delete_flag=0 order by id desc")
    public List<BlogInfo> selectAll();

    @Select("select id,title,content,user_id,update_time from blog where delete_flag=0 and id=#{id}")
    public BlogInfo selectById(Integer id);

    @Insert("insert into blog(title,content,user_id) values (#{title},#{content},#{userId})")
    public Integer insert(BlogInfo blogInfo);

    public Integer update(BlogInfo blogInfo);
}
