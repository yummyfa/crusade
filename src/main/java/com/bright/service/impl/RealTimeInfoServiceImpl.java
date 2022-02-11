package com.bright.service.impl;

import com.bright.dao.RealTimeInfoDao;
import com.bright.entity.RealTimeInfo;
import com.bright.service.RealTimeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/4 9:31
 */
@Service
public class RealTimeInfoServiceImpl implements RealTimeInfoService {

    private final Logger logger = LoggerFactory.getLogger(RealTimeInfoServiceImpl.class);

    @Resource
    private RealTimeInfoDao realTimeInfoDao;
    /**
     * 新建
     * @return
     */
    @Override
    public boolean saveInfo(RealTimeInfo realTimeInfo) {
        return realTimeInfoDao.saveInfo(realTimeInfo)>0;
    }

    /**
     * 更新
     * @return
     */
    @Override
    public boolean updateInfo(RealTimeInfo realTimeInfo) {
        return realTimeInfoDao.updateInfo(realTimeInfo);
    }

    @Override
    public List<RealTimeInfo> selectByMatchId(Integer matchId) {
        return realTimeInfoDao.selectByMatchId(matchId);
    }

    @Override
    public List<RealTimeInfo> selectAll() {
        return realTimeInfoDao.selectAll();
    }
}
