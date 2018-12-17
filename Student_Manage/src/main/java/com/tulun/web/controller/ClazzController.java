package com.tulun.web.controller;

import com.tulun.bean.Clazz;
import com.tulun.service.ClazzService;
import com.tulun.service.serviceimpl.ClazzServiceImpl;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/11 9:00
 */
public class ClazzController {
    private ClazzService cs;
    public ClazzController(){
        this.cs = new ClazzServiceImpl();
    }

    public Clazz getClazzInfo(String name){
        return cs.getClazzInfo(name);
    }

    public void remove(Integer id) {
        cs.removeClazzById(id);
    }

    public void modify(Clazz clazz) {
        cs.modifyClazz(clazz);
    }

    public int quert() {
        return cs.getClazzNumber();
    }

    public Clazz query(Integer id) {
        return cs.queryClazzById(id);
    }

    public void add(Clazz clazz) {
        cs.addClazz(clazz);
    }
}
