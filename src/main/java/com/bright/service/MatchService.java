package com.bright.service;

import com.bright.entity.Match;
import com.bright.req.EntryConditionDto;
import com.bright.req.EntryFactorReq;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/8 10:32
 */
public interface MatchService {

    /**
     * 保存数据
     */
    boolean saveMatch(Match match);

    /**
     * 修改数据
     */
    boolean updateMatch(Match match);

    /**
     * 查询所有
     */
    List<Match> selectAll();

    /**
     * 录入条件
     */
    boolean entryCondition(EntryConditionDto entryConditionDto);

    /**
     * 录入因素
     */
    boolean entryFactor(EntryFactorReq entryFactorReq);
}
