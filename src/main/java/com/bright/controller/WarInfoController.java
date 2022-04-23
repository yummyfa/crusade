package com.bright.controller;

import com.bright.constant.HttpCode;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.entity.WarInfo;
import com.bright.service.WarInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 10:36
 */
@RestController
@RequestMapping("/war")
public class WarInfoController {
    @Resource
    private WarInfoService warInfoService;

    /**
     * 新增数据
     */
    @PostMapping("/saveWar")
    @ApiOperation("新增数据")
    public ResultEntity<Boolean> saveWar(@RequestBody WarInfo warInfo) {
        boolean b = warInfoService.saveWar(warInfo);
        if (!b){
            return ResultTemplate.error(HttpCode.CODE_500,"保存失败");
        }
        return ResultTemplate.success("保存成功");
    }

    /**
     * 修改数据
     */
    @PostMapping("/updateWar")
    @ApiOperation("修改数据")
    public ResultEntity<Boolean> updateWar(@RequestBody WarInfo warInfo) {
        boolean b = warInfoService.updateWar(warInfo);
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
    public ResultEntity<List<WarInfo>> selectAll(){
        return ResultTemplate.successData(warInfoService.selectAll(),"查询成功");
    }

    /**
     * 根据名字查询信息
     */
    @GetMapping("/getWarInfoByName")
    @ApiOperation("根据名字查询信息")
    public ResultEntity<WarInfo> getWarInfoByName(String warName){
        return ResultTemplate.successData(warInfoService.getWarInfoByName(warName),"查询成功");
    }
}
