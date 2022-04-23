package com.bright.controller;

import com.bright.entity.WarMatch;
import com.bright.service.WarMatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (WarMatch)表控制层
 *
 * @author makejava
 * @since 2022-04-23 20:53:12
 */
@RestController
@RequestMapping("warMatch")
public class WarMatchController {
    /**
     * 服务对象
     */
    @Resource
    private WarMatchService warMatchService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<WarMatch> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.warMatchService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param warMatch 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<WarMatch> add(WarMatch warMatch) {
        return ResponseEntity.ok(this.warMatchService.insert(warMatch));
    }

    /**
     * 编辑数据
     *
     * @param warMatch 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<WarMatch> edit(WarMatch warMatch) {
        return ResponseEntity.ok(this.warMatchService.update(warMatch));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.warMatchService.deleteById(id));
    }

}

