package com.tulun.service.serviceimpl;

import com.tulun.bean.WebUser;
import com.tulun.dao.WebUserMapper;
import com.tulun.service.UserService;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(WebUser user) {
        SqlSession session=MyBatisUtils.getSession();
        try {
            WebUserMapper pm=session.getMapper(WebUserMapper.class);
            pm.insert(user);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void removeUser(WebUser user) {
        SqlSession session=MyBatisUtils.getSession();
        try {
            WebUserMapper pm=session.getMapper(WebUserMapper.class);
            pm.deleteByPrimaryKey(user.getId());
            // jedis.flushAll();
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void modifyUser(WebUser user) {
        SqlSession session = MyBatisUtils.getSession();
        try{
            WebUserMapper pm = session.getMapper(WebUserMapper.class);
            pm.updateByPrimaryKey(user);
            session.commit();
        } catch (Exception e){
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public WebUser queryUserByName(String name) {
        WebUser p=null;
        SqlSession session = MyBatisUtils.getSession();
        try{
            WebUserMapper pm = session.getMapper(WebUserMapper.class);
            p = pm.selectByName(name);
            return p;
        } finally {
            session.close();
        }
    }


}
