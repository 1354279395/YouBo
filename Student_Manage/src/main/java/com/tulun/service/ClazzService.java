package com.tulun.service;

import com.tulun.bean.Clazz;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:39
 */
public interface ClazzService {
    /**
     * 获取班级信息
     * @param name
     * @return
     */
    Clazz getClazzInfo(String name);

    void removeClazzById(Integer id);

    void modifyClazz(Clazz clazz);

    int getClazzNumber();

    Clazz queryClazzById(Integer id);

    void addClazz(Clazz clazz);
}
