package com.bright.controller;

import com.bright.entity.Match;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.req.EntryConditionDto;
import com.bright.req.EntryFactorReq;
import com.bright.service.MatchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/8 10:29
 */
@RestController
@RequestMapping("/match")
public class MatchController {

    @Resource
    private MatchService matchService;

    @PostMapping("/saveMatch")
    @ApiOperation("保存数据")
    public ResultEntity<Boolean> saveMatch(Match match){
        boolean b =matchService.saveMatch(match);
        if (!b){
            return ResultTemplate.fail("添加失败");
        }
        return ResultTemplate.success("添加成功");
    }

    @PostMapping("/updateMatch")
    @ApiOperation("修改数据")
    public ResultEntity<Boolean> updateMatch(Match match){
        boolean b =matchService.updateMatch(match);
        if (!b){
            return ResultTemplate.fail("修改失败");
        }
        return ResultTemplate.success("修改成功");
    }

    @GetMapping("/selectAll")
    @ApiOperation("查询所有")
    public ResultEntity<List<Match>> selectAll(){
        return ResultTemplate.successData(matchService.selectAll(),"查询成功");
    }

    @PostMapping("/entryCondition")
    @ApiOperation("录入条件")
    public ResultEntity<Boolean> entryCondition(EntryConditionDto entryConditionDto){
        boolean b =matchService.entryCondition(entryConditionDto);
        if (!b){
            return ResultTemplate.fail("添加失败");
        }
        return ResultTemplate.success("添加成功");
    }

    @PostMapping("/entryFactor")
    @ApiOperation("录入因素")
    public ResultEntity<Boolean> entryFactor(EntryFactorReq entryFactorReq){
        boolean b =matchService.entryFactor(entryFactorReq);
        if (!b){
            return ResultTemplate.fail("添加失败");
        }
        return ResultTemplate.success("添加成功");
    }
}
