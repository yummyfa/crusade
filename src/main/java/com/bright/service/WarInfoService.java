package com.bright.service;

import com.bright.entity.WarInfo;

import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 10:41
 */
public interface WarInfoService {

    boolean saveWar(WarInfo warInfo);

    boolean updateWar(WarInfo warInfo);

    List<WarInfo> selectAll();
}
