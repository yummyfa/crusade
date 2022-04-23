package com.bright.service.impl;

import com.bright.entity.WarMatch;
import com.bright.dao.WarMatchDao;
import com.bright.service.WarMatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WarMatch)表服务实现类
 *
 * @author makejava
 * @since 2022-04-23 20:53:21
 */
@Service("warMatchService")
public class WarMatchServiceImpl implements WarMatchService {
    @Resource
    private WarMatchDao warMatchDao;

    /**
     * 通过ID查询单条数据
     *
     * @param warId 主键
     * @return 实例对象
     */
    @Override
    public WarMatch queryById(Integer warId) {
        return this.warMatchDao.queryById(warId);
    }

    /**
     * 新增数据
     *
     * @param warMatch 实例对象
     * @return 实例对象
     */
    @Override
    public WarMatch insert(WarMatch warMatch) {
        this.warMatchDao.insert(warMatch);
        return warMatch;
    }

    /**
     * 修改数据
     *
     * @param warMatch 实例对象
     * @return 实例对象
     */
    @Override
    public WarMatch update(WarMatch warMatch) {
        this.warMatchDao.update(warMatch);
        return this.queryById(warMatch.getWarId());
    }

    /**
     * 通过主键删除数据
     *
     * @param warId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer warId) {
        return this.warMatchDao.deleteById(warId) > 0;
    }

    /**
     * 批量插入
     *
     * @param warMatches 实例对象
     * @return 是否成功
     */
    @Override
    public boolean batchInsert(List<WarMatch> warMatches) {
        int i = warMatchDao.insertBatch(warMatches);
        return i > 0;
    }
}
