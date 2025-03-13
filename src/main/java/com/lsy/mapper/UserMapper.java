package com.lsy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsy.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


    @Select("select * from user_td where name =#{name}")
    List<UserEntity> getUserInfos(@Param("name") String name);


    List<UserEntity> getUserInfoSByMapper(@Param("name") String name);
}
