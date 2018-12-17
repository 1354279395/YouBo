package com.tulun.service.serviceimpl;

import com.tulun.bean.Clazz;
import com.tulun.dao.ClazzMapper;
import com.tulun.dao.StudentMapper;
import com.tulun.service.ClazzService;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/11 8:54
 */
public class ClazzServiceImpl implements ClazzService {
    @Override
    public Clazz getClazzInfo(String name) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            ClazzMapper cm = session.getMapper(ClazzMapper.class);
            return cm.getClazzInfoByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeClazzById(Integer id) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            ClazzMapper cm = session.getMapper(ClazzMapper.class);
            cm.deleteByPrimaryKey(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void modifyClazz(Clazz clazz) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            ClazzMapper cm = session.getMapper(ClazzMapper.class);
            cm.updateByPrimaryKey(clazz);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public int getClazzNumber() {
        SqlSession session = MyBatisUtils.getSession();
        try {
            ClazzMapper cm = session.getMapper(ClazzMapper.class);
            return cm.getClazzNum();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Clazz queryClazzById(Integer id) {
        Clazz clazz;
        try (SqlSession session = MyBatisUtils.getSession()) {
            ClazzMapper tm = session.getMapper(ClazzMapper.class);
            clazz = tm.selectByPrimaryKey(id);
            return clazz;
        }
    }

    @Override
    public void addClazz(Clazz clazz) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            ClazzMapper cm = session.getMapper(ClazzMapper.class);
            cm.insert(clazz);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }
}
