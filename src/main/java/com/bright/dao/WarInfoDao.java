package com.bright.dao;

import com.bright.entity.WarInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 10:43
 */
@Mapper
public interface WarInfoDao {

    /**
     * 保存
     */
    int saveWar(WarInfo warInfo);

    boolean updateWar(WarInfo warInfo);

    List<WarInfo> selectAll();

    WarInfo getWarInfoByName(String warName);
}
