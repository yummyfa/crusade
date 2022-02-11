package com.bright.service;

import com.bright.entity.ExternalFactor;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/6 17:27
 */
public interface FactorService {

    /**
     * 根据比赛id查询因素
     */
    List<ExternalFactor> selectFactorByMatchId(Integer matchId);

    /**
     * 保存
     */
    boolean saveFactor(ExternalFactor externalFactor);

    /**
     * 修改
     * @param externalFactor
     * @return
     */
    boolean updateFactor(ExternalFactor externalFactor);

    List<ExternalFactor> selectAll();
}
