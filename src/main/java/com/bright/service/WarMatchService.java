package com.bright.service;

import com.bright.entity.WarMatch;

import java.util.List;

/**
 * (WarMatch)表服务接口
 *
 * @author makejava
 * @since 2022-04-23 20:53:18
 */
public interface WarMatchService {

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
     * @return 实例对象
     */
    WarMatch insert(WarMatch warMatch);

    /**
     * 修改数据
     *
     * @param warMatch 实例对象
     * @return 实例对象
     */
    WarMatch update(WarMatch warMatch);

    /**
     * 通过主键删除数据
     *
     * @param warId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer warId);

    /**
     * 批量插入
     */
    boolean batchInsert(List<WarMatch> warMatches);
}
