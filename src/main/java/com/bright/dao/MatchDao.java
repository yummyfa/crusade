package com.bright.dao;

import com.bright.entity.Match;
import com.bright.req.EntryFactorReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/8 10:34
 */
@Mapper
public interface MatchDao {

    int saveMatch(Match match);

    boolean updateMatch(Match match);

    List<Match> selectAll();

    boolean entryCondition(@Param("matchId") Integer matchId,@Param("conditionId") Integer conditionId);

    boolean entryFactor(EntryFactorReq entryFactorReq);

    /**
     * 批量插入
     */
    boolean batchInsert(@Param("matches") List<Match> matches);

    /**
     * 根据比赛时间和队伍查询
     * @param bjTime 比赛时间
     * @param nationOne 主队
     * @param nationTwo 客队
     * @return 比赛信息
     */
    Match selectByTimeAndTeam(@Param("bjTime")String bjTime, @Param("nationOne")String nationOne,
                              @Param("nationTwo") String nationTwo);
}
