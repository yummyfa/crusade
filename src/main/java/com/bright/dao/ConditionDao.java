package com.bright.dao;

import com.bright.entity.Condition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//import org.springframework.data.domain.Pageable;

import java.util.List;




/**
 * (Condition)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-24 20:05:58
 */
@Mapper
public interface ConditionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Condition queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param condition 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Condition> queryAllByLimit(Condition condition, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param condition 查询条件
     * @return 总行数
     */
    long count(Condition condition);

    /**
     * 新增数据
     *
     * @param condition 实例对象
     * @return 影响行数
     */
    int insert(Condition condition);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Condition> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Condition> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Condition> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Condition> entities);

    /**
     * 修改数据
     *
     * @param condition 实例对象
     * @return 影响行数
     */
    int update(Condition condition);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Condition> selectAll();

    List<Condition> selectByMatchId(Integer matchId);
}

