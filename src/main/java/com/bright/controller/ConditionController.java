package com.bright.controller;

import com.bright.entity.Condition;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.service.ConditionService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Condition)表控制层
 *
 * @author makejava
 * @since 2021-11-24 20:05:55
 */
@Api(tags = "条件")
@RestController
@RequestMapping("condition")
public class ConditionController {
    /**
     * 服务对象
     */
    @Resource
    private ConditionService conditionService;

    /**
     * 分页查询
     *
     * @param condition 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Condition>> queryByPage(Condition condition, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.conditionService.queryByPage(condition, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Condition> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.conditionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param condition 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增")
    public ResponseEntity<Condition> add(Condition condition) {
        return ResponseEntity.ok(this.conditionService.insert(condition));
    }

    /**
     * 编辑数据
     *
     * @param condition 实体
     * @return 编辑结果
     */
    @PutMapping
    @ApiOperation("编辑")
    public ResponseEntity<Condition> edit(Condition condition) {
        return ResponseEntity.ok(this.conditionService.update(condition));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.conditionService.deleteById(id));
    }

    /**
     * 查询所有的信息
     */
    @GetMapping("/selectAll")
    @ApiOperation("查询所有的信息")
    public ResultEntity<List<Condition>> selectAll(){
        return ResultTemplate.successData(conditionService.selectAll(),"查询成功");
    }
}

