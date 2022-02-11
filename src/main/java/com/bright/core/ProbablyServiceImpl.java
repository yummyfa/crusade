package com.bright.core;

import com.bright.entity.*;
import com.bright.req.RateMessageReq;
import com.bright.res.RateMessageRes;
import com.bright.service.ConditionService;
import com.bright.service.FactorService;
import com.bright.service.PredictService;
import com.bright.service.RealTimeInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/6 14:57
 */
@Service
public class ProbablyServiceImpl implements ProbablyService{

    @Resource
    private RealTimeInfoService realTimeInfoService;

    @Resource
    private PredictService predictService;

    @Resource
    private FactorService factorService;

    @Resource
    private ConditionService conditionService;

    @Override
    public ResultEntity<List<RateMessageRes>> getResult(RateMessageReq rateMessageReq) {
        Predict predict = new Predict();
        BeanUtils.copyProperties(rateMessageReq,predict);
        predictService.savePredict(predict);
        Integer matchId = rateMessageReq.getMatchId();
        //根据matchId 查询出factor 和condition  和 实时
        List<RealTimeInfo> realTimeInfos = realTimeInfoService.selectByMatchId(matchId);
        List<ExternalFactor> externalFactors = factorService.selectFactorByMatchId(matchId);
        List<Condition> conditions = conditionService.selectByMatchId(matchId);

        return null;
    }
}
