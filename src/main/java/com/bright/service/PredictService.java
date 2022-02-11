package com.bright.service;

import com.bright.entity.Predict;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 14:23
 */
public interface PredictService {

    /**
     * 保存数据
     */
    boolean savePredict(Predict predict);

    /**
     * 修改数据
     */
    boolean updatePredict(Predict predict);

    /**
     * 查询所有数据
     */
    List<Predict> selectAll();
}
