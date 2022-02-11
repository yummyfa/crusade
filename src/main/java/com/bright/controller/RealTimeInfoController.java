package com.bright.controller;

import com.bright.constant.HttpCode;
import com.bright.entity.*;
import com.bright.service.RealTimeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/4 9:23
 */
@Api(tags = "实时")
@RestController
@RequestMapping("realTimeInfo")
public class RealTimeInfoController {
    @Resource
    private RealTimeInfoService realTimeInfoService;

    /**
     * 新增数据
     */
    @PostMapping("/saveInfo")
    @ApiOperation(value = "新增数据")
    public ResultEntity<Boolean> saveInfo(@RequestBody RealTimeInfo realTimeInfo) {
        boolean b = realTimeInfoService.saveInfo(realTimeInfo);
        if (!b){
            return ResultTemplate.error(HttpCode.CODE_500,"保存失败");
        }
        return ResultTemplate.success("保存成功");
    }

    /**
     * 修改数据
     */
    @PostMapping("/updateInfo")
    @ApiOperation(value = "修改数据")
    public ResultEntity<Boolean> updateInfo(@RequestBody RealTimeInfo realTimeInfo) {
        boolean b = realTimeInfoService.updateInfo(realTimeInfo);
        if (!b){
            return ResultTemplate.error(HttpCode.CODE_500,"更新失败");
        }
        return ResultTemplate.success("更新成功");
    }

    /**
     * 查询所有的信息
     */
    @GetMapping("/selectAll")
    @ApiOperation("查询所有的信息")
    public ResultEntity<List<RealTimeInfo>> selectAll(){
        return ResultTemplate.successData(realTimeInfoService.selectAll(),"查询成功");
    }

}
