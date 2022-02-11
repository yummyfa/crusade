package com.bright.service.impl;

import com.bright.dao.PredictDao;
import com.bright.entity.Predict;
import com.bright.service.PredictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 14:25
 */
@Service
public class PredictServiceImpl implements PredictService {

    @Resource
    private PredictDao predictDao;

    @Override
    public boolean savePredict(Predict predict) {

        return predictDao.savePredict(predict);
    }

    @Override
    public boolean updatePredict(Predict predict) {
        return predictDao.updatePredict(predict);
    }

    @Override
    public List<Predict> selectAll() {
        return predictDao.selectAll();
    }
}
