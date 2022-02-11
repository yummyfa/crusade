package com.bright.core;

import com.bright.entity.ResultEntity;
import com.bright.req.RateMessageReq;
import com.bright.res.RateMessageRes;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/6 14:56
 */
public interface ProbablyService {

    ResultEntity<List<RateMessageRes>> getResult(RateMessageReq rateMessageReq);
}
