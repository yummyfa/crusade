package com.bright.dao;

import com.bright.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Company)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-13 14:19:51
 */
@Mapper
public interface CompanyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param companyId 主键
     * @return 实例对象
     */
    Company queryById(Integer companyId);

    /**
     * 查询指定行数据
     *
     * @param company 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Company> queryAllByLimit(Company company, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param company 查询条件
     * @return 总行数
     */
    long count(Company company);

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int insert(Company company);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Company> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Company> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Company> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Company> entities);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param companyId 主键
     * @return 影响行数
     */
    int deleteById(Integer companyId);

    Company selectByCompany(@Param("companyName") String companyName,@Param("companyId") Integer companyId);
}

