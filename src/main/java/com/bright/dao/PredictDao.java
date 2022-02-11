package com.bright.dao;

import com.bright.entity.Predict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 14:26
 */
@Mapper
public interface PredictDao {

    boolean savePredict(Predict predict);

    boolean updatePredict(Predict predict);

    List<Predict> selectAll();
}
