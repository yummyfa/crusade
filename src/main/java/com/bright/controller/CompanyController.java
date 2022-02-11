package com.bright.controller;

import com.bright.entity.Company;
import com.bright.service.CompanyService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Company)表控制层
 *
 * @author makejava
 * @since 2021-11-13 14:19:49
 */
@Api(tags = "企业")
@RestController
@RequestMapping("company")
public class CompanyController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyService companyService;

//    /**
//     * 分页查询
//     *
//     * @param company 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<Company>> queryByPage(Company company, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.companyService.queryByPage(company, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Company> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.companyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param company 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增")
    public ResponseEntity<Company> add(Company company) {
        return ResponseEntity.ok(this.companyService.insert(company));
    }

    /**
     * 编辑数据
     *
     * @param company 实体
     * @return 编辑结果
     */
    @PutMapping
    @ApiOperation("编辑")
    public ResponseEntity<Company> edit(Company company) {
        return ResponseEntity.ok(this.companyService.update(company));
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
        return ResponseEntity.ok(this.companyService.deleteById(id));
    }

    /**
     * 根据条件查询
     */
    @GetMapping("/selectByCompany")
    @ApiOperation("查询所有的信息")
    public ResponseEntity<Company> selectByCompany(@RequestParam("companyName") String companyName,
                                                   @RequestParam("companyId") Integer companyId) {
        return ResponseEntity.ok(this.companyService.selectByCompany(companyName,companyId));
    }
}

