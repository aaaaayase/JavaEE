package com.yun.mybatis.mapper;

import com.yun.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select *from userinfo")
    public List<UserInfo> queryUserInfos(); // 这里接收的数据库中的数据是有问题的 因为实体类的部分属性与数据库的部分字段名不是完全相符的
    // 对于这种接收的问题 我们采取三种方式解决
    // 1. 直接添加配置项 将加_的字段名以及小驼峰的属性名自动地相互转换

    // 2. 起别名 保持别名和实体类名一致
    @Select("select id,username,password,age,gender,phone,delete_flag as deleteFlag,create_time as createTime,update_time as updateTime from userinfo")
    public List<UserInfo> queryUserInfos2();

    // 3. 结果映射
    @Results(id = "baseMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select *from userinfo")
    public List<UserInfo> queryUserInfos3();

    // 复用结果映射
    @Select("select *from userinfo")
    @ResultMap(value = "baseMap")
    public List<UserInfo> queryUserInfos4();

    // 单参数不需要去管语句以及函数的参数名 会直接将唯一的参数放到语句当中
    @Select("select * from userinfo where id= #{value}")
    public List<UserInfo> queryUserInfo5(Integer x);

    // 传递多参数名称需要一致
    @Select("select *from userinfo where username= #{name} and id= #{id}")
    public UserInfo queryUserInfo6(Integer id, String name);

    // 传递多参数时会按照参数顺序生成param* 可以在sql语句中使用param来进行传参
    @Select("select *from userinfo where username= #{param2} and id= #{param1}")
    public UserInfo queryUserInfo7(Integer id, String name);

    // 使用param注解起别名 此时和sql语句相联系的就是param注解中的别名 别名需要与sql语句中的字段名相同
    @Select("select *from userinfo where username= #{name} and id= #{id}")
    public UserInfo queryUserInfo8(@Param("id") Integer id, @Param("name") String name);

    // 插入
    @Insert("insert into userinfo (username,password,age,gender,phone) values (#{userName},#{password},#{age},#{gender},#{phone})")
    public Integer insert(UserInfo userInfo);

    // 加上param注解后就不会自动拆开属性了 此时就需要逐一赋值
    // 加上option注解可以获取自增的id 从插入的对象中获取
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username,password,age,gender,phone) values (#{userInfo.userName},#{userInfo.password},#{userInfo.age},#{userInfo.gender},#{userInfo.phone})")
    public Integer insert2(@Param("userInfo") UserInfo userInfo);

    // 更新
    @Update("update userinfo set username=#{userName} where id=#{id}")
    public Integer update(UserInfo userInfo);

    // 删除
    @Delete("delete from userinfo where id=#{id}")
    public Integer delete(Integer id);
}
