package com.bright.service.impl;

import com.bright.dao.WarInfoDao;
import com.bright.entity.WarInfo;
import com.bright.service.WarInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 10:42
 */
@Service
public class WarInfoServiceImpl implements WarInfoService {

    @Resource
    private WarInfoDao warInfoDao;
    @Override
    public boolean saveWar(WarInfo warInfo) {
        return warInfoDao.saveWar(warInfo)>0;
    }

    @Override
    public boolean updateWar(WarInfo warInfo) {
        return warInfoDao.updateWar(warInfo);
    }

    @Override
    public List<WarInfo> selectAll() {
        return warInfoDao.selectAll();
    }

    @Override
    public WarInfo getWarInfoByName(String warName) {
        return warInfoDao.getWarInfoByName(warName);
    }
}
