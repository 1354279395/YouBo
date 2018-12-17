package com.tulun.dao;

import com.tulun.bean.Clazz;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

    Clazz getClazzInfoByName(String name);

    int getClazzNum();
}