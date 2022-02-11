package com.bright.service;

import com.bright.entity.RealTimeInfo;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/4 9:25
 */
public interface RealTimeInfoService {

    boolean saveInfo(RealTimeInfo realTimeInfo);

    boolean updateInfo(RealTimeInfo realTimeInfo);

    List<RealTimeInfo> selectByMatchId(Integer matchId);

    List<RealTimeInfo> selectAll();
}
