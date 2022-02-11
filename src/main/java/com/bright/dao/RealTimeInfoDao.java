package com.bright.dao;

import com.bright.entity.RealTimeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: wangliang
 * @date: 2021/12/4 9:33
 */
@Mapper
public interface RealTimeInfoDao {

    int saveInfo(RealTimeInfo realTimeInfo);

    boolean updateInfo(RealTimeInfo realTimeInfo);

    List<RealTimeInfo> selectByMatchId(Integer matchId);

    List<RealTimeInfo> selectAll();
}
