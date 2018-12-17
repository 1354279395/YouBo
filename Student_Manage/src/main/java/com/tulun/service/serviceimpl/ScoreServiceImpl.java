package com.tulun.service.serviceimpl;

import com.tulun.bean.Score;
import com.tulun.dao.ScoreMapper;
import com.tulun.service.ScoreService;
import com.tulun.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class ScoreServiceImpl implements ScoreService {
    @Override
    public void addScore(Score score) {
        SqlSession session=MyBatisUtils.getSession();
        try {
            ScoreMapper pm=session.getMapper(ScoreMapper.class);
            pm.insert(score);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void removeScore(Integer id) {
        SqlSession session=MyBatisUtils.getSession();
        try {
            ScoreMapper pm=session.getMapper(ScoreMapper.class);
            pm.deleteByPrimaryKey(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void modifyScore(Score score) {
        SqlSession session = MyBatisUtils.getSession();
        try{
            ScoreMapper pm = session.getMapper(ScoreMapper.class);
            pm.updateByPrimaryKey(score);
            session.commit();
        } catch (Exception e){
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Score queryScore(Integer id) {
        Score p=null;
        SqlSession session = MyBatisUtils.getSession();
        try{
            ScoreMapper pm = session.getMapper(ScoreMapper.class);
            p = pm.selectByPrimaryKey(id);
            return p;
        } finally {
            session.close();
        }
    }

    @Override
    public int getScoreNumber() {
        SqlSession session = MyBatisUtils.getSession();
        try {
            ScoreMapper sm = session.getMapper(ScoreMapper.class);
            return sm.getScoreNum();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
