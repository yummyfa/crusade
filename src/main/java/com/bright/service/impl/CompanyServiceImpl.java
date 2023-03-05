package com.bright.service.impl;

import com.bright.entity.Company;
import com.bright.dao.CompanyDao;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.service.CompanyService;
import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Company)表服务实现类
 *
 * @author makejava
 * @since 2021-11-13 14:19:54
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyDao companyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param companyId 主键
     * @return 实例对象
     */
    @Override
    public Company queryById(Integer companyId) {
        return this.companyDao.queryById(companyId);
    }

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<Company> queryByPage(Company company, PageRequest pageRequest) {
//        long total = this.companyDao.count(company);
//        return new PageImpl<>(this.companyDao.queryAllByLimit(company, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    @Override
    public Company insert(Company company) {
        this.companyDao.insert(company);
        return company;
    }

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    @Override
    public Company update(Company company) {
        this.companyDao.update(company);
        return this.queryById(company.getCompanyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param companyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer companyId) {
        return this.companyDao.deleteById(companyId) > 0;
    }

    @Override
    public ResultEntity<Company> selectByCompany(String companyName, Integer companyId) {
        Company company = this.companyDao.selectByCompany(companyName, companyId);
        return ResultTemplate.successData(company, "查询成功");
    }
}
