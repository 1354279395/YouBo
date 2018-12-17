package com.tulun.web.controller;

import com.tulun.bean.Score;
import com.tulun.service.ScoreService;
import com.tulun.service.serviceimpl.ScoreServiceImpl;

public class Scorecontroller {
    private ScoreService sc;

    public Scorecontroller(){
        sc=new ScoreServiceImpl();
    }

    public void remove(Integer id) {
        sc.removeScore(id);
    }

    public void modify(Score score) {
        sc.modifyScore(score);
    }

    public int quert() {
        return sc.getScoreNumber();
    }

    public Score query(Integer id) {
        return sc.queryScore(id);
    }

    public void add(Score score) {
        sc.addScore(score);
    }
}
