package com.bright.dao;

import com.bright.entity.WarMatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WarMatch)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-23 20:53:13
 */
public interface WarMatchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param warId 主键
     * @return 实例对象
     */
    WarMatch queryById(Integer warId);

    /**
     * 新增数据
     *
     * @param warMatch 实例对象
     * @return 影响行数
     */
    int insert(WarMatch warMatch);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarMatch> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WarMatch> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarMatch> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<WarMatch> entities);

    /**
     * 修改数据
     *
     * @param warMatch 实例对象
     * @return 影响行数
     */
    int update(WarMatch warMatch);

    /**
     * 通过主键删除数据
     *
     * @param warId 主键
     * @return 影响行数
     */
    int deleteById(Integer warId);

}

