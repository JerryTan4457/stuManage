package com.yfkj.stumanage.mapper;


import com.yfkj.stumanage.pojo.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User userlogin(User user);
    
}