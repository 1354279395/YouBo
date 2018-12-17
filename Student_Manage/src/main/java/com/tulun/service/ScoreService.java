package com.tulun.service;

import com.tulun.bean.Score;

public interface ScoreService {
    void addScore(Score score);
    void removeScore(Integer id);
    void modifyScore(Score score);
    Score queryScore(Integer id);
    int getScoreNumber();
}
