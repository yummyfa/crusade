package com.bright.service.impl;

import com.bright.dao.MatchDao;
import com.bright.entity.Condition;
import com.bright.entity.Match;
import com.bright.req.EntryConditionDto;
import com.bright.req.EntryFactorReq;
import com.bright.service.ConditionService;
import com.bright.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/8 10:33
 */
@Service
public class MatchServiceImpl implements MatchService {

    private static final Logger logger = LoggerFactory.getLogger(MatchServiceImpl.class);
    @Resource
    private MatchDao matchDao;
    @Resource
    private ConditionService conditionService;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveMatch(Match match) {
        boolean b = false;
        try {
            int i = matchDao.saveMatch(match);
            b = i>0;
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return b;
    }

    /**
     * 修改数据
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean updateMatch(Match match) {
        boolean b = false;
        try {
            b = matchDao.updateMatch(match);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return b;
    }

    @Override
    public List<Match> selectAll() {
        return matchDao.selectAll();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean entryCondition(EntryConditionDto entryConditionDto) {
        boolean b;
        try {
            Condition condition = new Condition();
            BeanUtils.copyProperties(entryConditionDto,condition);
            Condition insert = conditionService.insert(condition);
            Integer id = insert.getId();
            b =matchDao.entryCondition(entryConditionDto.getMatchId(),id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return b;
    }

    @Override
    public boolean entryFactor(EntryFactorReq entryFactorReq) {
        return matchDao.entryFactor(entryFactorReq);
    }

    /**
     * 批量插入
     */
    @Override
    public boolean batchInsert(List<Match> matches) {
        return matchDao.batchInsert(matches);
    }

    @Override
    public Match selectByTimeAndTeam(String bjTime, String nationOne, String nationTwo) {
        return matchDao.selectByTimeAndTeam(bjTime, nationOne, nationTwo);
    }
}
