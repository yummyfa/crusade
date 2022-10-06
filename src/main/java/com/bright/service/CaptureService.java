package com.bright.service;

import com.bright.entity.ResultEntity;
import com.bright.req.MatchDto;

/**
 * @author wangliang
 * @date 2022/10/5 17:28
 */
public interface CaptureService {
    ResultEntity saveMatchInfo(String match, String level);

    ResultEntity saveResult(MatchDto match);

    ResultEntity change();

}
