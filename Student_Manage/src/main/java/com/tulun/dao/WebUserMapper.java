package com.tulun.dao;

import com.tulun.bean.WebUser;

public interface WebUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);

    WebUser selectByName(String name);
}