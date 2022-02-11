package com.bright.controller;

import com.bright.constant.HttpCode;
import com.bright.entity.*;
import com.bright.service.FactorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/6 17:27
 */
@Api(tags = "因素")
@RestController
@RequestMapping("/factor")
public class FactorController {

    @Resource
    private FactorService factorService;

    /**
     * 根据比赛id查询因素
     * @param matchId
     * @return
     */
    @GetMapping("/selectFactorByMatchId")
    @ApiOperation(value = "获取因素")
    public ResultEntity<List<ExternalFactor>> getFactorById(Integer matchId){
        return ResultTemplate.successData(factorService.selectFactorByMatchId(matchId),"查询成功");
    }

    /**
     * 新增数据
     */
    @PostMapping("/saveFactor")
    @ApiOperation("新增数据")
    public ResultEntity<Boolean> saveFactor(@RequestBody ExternalFactor externalFactor) {
        boolean b = factorService.saveFactor(externalFactor);
        if (!b){
            return ResultTemplate.error(HttpCode.CODE_500,"保存失败");
        }
        return ResultTemplate.success("保存成功");
    }

    /**
     * 修改数据
     */
    @PostMapping("/updateFactor")
    @ApiOperation("修改数据")
    public ResultEntity<Boolean> updateFactor(@RequestBody ExternalFactor externalFactor) {
        boolean b = factorService.updateFactor(externalFactor);
        if (!b){
            return ResultTemplate.error(HttpCode.CODE_500,"修改失败");
        }
        return ResultTemplate.success("修改成功");
    }

    /**
     * 查询所有的信息
     */
    @GetMapping("/selectAll")
    @ApiOperation("查询所有的信息")
    public ResultEntity<List<ExternalFactor>> selectAll(){
        return ResultTemplate.successData(factorService.selectAll(),"查询成功");
    }
}
