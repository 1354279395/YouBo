package com.tulun.service.serviceimpl;

import com.tulun.bean.Teacher;
import com.tulun.dao.TeacherMapper;
import com.tulun.service.TeacherService;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 23:27
 */
public class TeacherServiceImpl implements TeacherService {
    @Override
    public void addTeacher(Teacher t) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            TeacherMapper tm = session.getMapper(TeacherMapper.class);
            tm.insert(t);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Teacher queryTeacherById(Integer id) {
        Teacher teacher;
        try (SqlSession session = MyBatisUtils.getSession()) {
            TeacherMapper tm = session.getMapper(TeacherMapper.class);
            teacher = tm.selectByPrimaryKey(id);
            return teacher;
        }
    }

    @Override
    public Teacher queryTeacherByName(String name) {
        return null;
    }

    @Override
    public void removeTeacherById(Integer id) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            TeacherMapper tm = session.getMapper(TeacherMapper.class);
            tm.deleteByPrimaryKey(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void modifyTeacherById(Teacher t) {
        SqlSession session = MyBatisUtils.getSession();
        try {
            TeacherMapper tm = session.getMapper(TeacherMapper.class);
            System.out.println("update数据库");
            System.out.println("更新数据库 + " + tm.updateByPrimaryKey(t));
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public int getTeacherNumber() {
        SqlSession session = MyBatisUtils.getSession();
        try {
            TeacherMapper tm = session.getMapper(TeacherMapper.class);
            return tm.getTeacherNum();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
