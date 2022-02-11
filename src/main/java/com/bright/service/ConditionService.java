package com.bright.service;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

import com.bright.entity.Condition;

import java.util.List;

/**
 * (Condition)表服务接口
 *
 * @author makejava
 * @since 2021-11-24 20:06:04
 */
public interface ConditionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Condition queryById(Integer id);

    /**
     * 分页查询
     *
     * @param condition 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<Condition> queryByPage(Condition condition, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param condition 实例对象
     * @return 实例对象
     */
    Condition insert(Condition condition);

    /**
     * 修改数据
     *
     * @param condition 实例对象
     * @return 实例对象
     */
    Condition update(Condition condition);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查詢所有
     * @return
     */
    List<Condition> selectAll();


    /**
     * 根据matchId查询
     */
    List<Condition> selectByMatchId(Integer matchId);
}
