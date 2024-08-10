package com.yun.messagewall.mapper;

import com.yun.messagewall.model.MessageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    // 查询
    public List<MessageInfo> select();
    // 插入
    public Integer insert(MessageInfo message);
}
