package com.bright.core;

import com.bright.entity.ResultEntity;
import com.bright.req.RateMessageReq;
import com.bright.res.RateMessageRes;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/4 17:21
 */
@Api(tags = "结果")
@RestController
@RequestMapping("/gossip")
public class ProbablyController {

    @Resource
    private ProbablyService probablyService;

    @GetMapping("/getResult")
    public ResultEntity<List<RateMessageRes>> getResult(@RequestBody RateMessageReq rateMessageReq){
        return probablyService.getResult(rateMessageReq);
    }
}
