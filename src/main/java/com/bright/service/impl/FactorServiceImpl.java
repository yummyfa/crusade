package com.bright.service.impl;

import com.bright.dao.FactorDao;
import com.bright.entity.ExternalFactor;
import com.bright.service.FactorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/6 18:08
 */
@Service
public class FactorServiceImpl implements FactorService {

    @Resource
    private FactorDao factorDao;

    /**
     * 根据比赛id查询因素
     * @return
     */
    @Override
    public List<ExternalFactor> selectFactorByMatchId(Integer matchId) {
        return factorDao.selectFactorByMatchId(matchId);
    }

    @Override
    public boolean saveFactor(ExternalFactor externalFactor) {
        return factorDao.saveFactor(externalFactor)>0;
    }

    @Override
    public boolean updateFactor(ExternalFactor externalFactor) {
        return factorDao.updateFactor(externalFactor);
    }

    @Override
    public List<ExternalFactor> selectAll() {
        return factorDao.selectAll();
    }
}
