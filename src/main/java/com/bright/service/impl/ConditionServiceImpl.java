package com.bright.service.impl;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
import com.bright.entity.Condition;
import com.bright.service.ConditionService;
import org.springframework.stereotype.Service;
import com.bright.dao.ConditionDao;
import javax.annotation.Resource;
import java.util.List;


/**
 * (Condition)表服务实现类
 *
 * @author makejava
 * @since 2021-11-24 20:06:05
 */
@Service("conditionService")
public class ConditionServiceImpl implements ConditionService {
    @Resource
    private ConditionDao conditionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Condition queryById(Integer id) {
        return this.conditionDao.queryById(id);
    }

//    @Override
//    public Condition insert(Condition condition) {
//        return null;
//    }

    /**
     * 分页查询
     *
     * @param condition 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<Condition> queryByPage(Condition condition, PageRequest pageRequest) {
//        long total = this.conditionDao.count(condition);
//        return new PageImpl<>(this.conditionDao.queryAllByLimit(condition, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param condition 实例对象
     * @return 实例对象
     */
    @Override
    public Condition insert(Condition condition) {
        this.conditionDao.insert(condition);
        return condition;
    }

    /**
     * 修改数据
     *
     * @param condition 实例对象
     * @return 实例对象
     */
    @Override
    public Condition update(Condition condition) {
        this.conditionDao.update(condition);
        return this.queryById(condition.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.conditionDao.deleteById(id) > 0;
    }

    @Override
    public List<Condition> selectAll() {
        return conditionDao.selectAll();
    }

    @Override
    public List<Condition> selectByMatchId(Integer matchId) {
        return conditionDao.selectByMatchId(matchId);
    }
}
