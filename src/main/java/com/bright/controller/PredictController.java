package com.bright.controller;

import com.bright.constant.HttpCode;
import com.bright.entity.Predict;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.entity.WarInfo;
import com.bright.service.PredictService;
import com.bright.service.WarInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 14:52
 */
@RestController
@RequestMapping("/predict")
public class PredictController {

    @Resource
    private PredictService predictService;

    /**
     * 新增数据
     */
    @PostMapping("/savePredict")
    @ApiOperation("新增数据")
    public ResultEntity<Boolean> savePredict(@RequestBody Predict predict) {
        boolean b = predictService.savePredict(predict);
        if (!b){
            return ResultTemplate.error(HttpCode.CODE_500,"保存失败");
        }
        return ResultTemplate.success("保存成功");
    }

    /**
     * 修改数据
     */
    @PostMapping("/updatePredict")
    @ApiOperation("修改数据")
    public ResultEntity<Boolean> updatePredict(@RequestBody Predict predict) {
        boolean b = predictService.updatePredict(predict);
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
    public ResultEntity<List<Predict>> selectAll(){
        return ResultTemplate.successData(predictService.selectAll(),"查询成功");
    }
}
