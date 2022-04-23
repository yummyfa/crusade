package com.bright.dao;

import com.bright.entity.SysLogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogDao {

    /**
     * 插入日志
     * @param sysLogEntity 操作记录信息
     */
    void insert(SysLogEntity sysLogEntity);
}
