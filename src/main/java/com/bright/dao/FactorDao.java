package com.bright.dao;

import com.bright.entity.ExternalFactor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/6 18:09
 */
@Mapper
public interface FactorDao {

    /**
     * 根据比赛id查询因素
     */
    List<ExternalFactor> selectFactorByMatchId(Integer matchId);

    int saveFactor(@Param("externalFactor") ExternalFactor externalFactor);

    boolean updateFactor(ExternalFactor externalFactor);

    List<ExternalFactor> selectAll();
}
