package com.bright.service.impl;

import com.bright.entity.Company;
import com.bright.entity.Condition;
import com.bright.service.CompanyService;
import com.bright.service.ConditionService;
import com.bright.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: wangliang
 * @Date: 2022/2/25 9:35
 */
@Service
public class TestControllerImpl implements TestService {

    @Resource
    private CompanyService companyService;

    @Resource
    private ConditionService conditionService;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void test1() {
        try {
            Company company = new Company();
            company.setCompanyName("fadfa");
            companyService.insert(company);
            Condition condition = new Condition();
            condition.setHumidity("rewrwe");
            conditionService.insert(condition);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
