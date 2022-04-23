package com.bright.aop;

import com.alibaba.fastjson.JSON;
import com.bright.common.SysLog;
import com.bright.dao.SysLogDao;
import com.bright.entity.SysLogEntity;
import com.bright.util.ReqIpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author wangliang
 * @date 2022/4/23 22:34
 */
@Aspect
@Component
public class SysLogAspect {
    private final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    public final static int MAX_PARAM_LENGTH = 500;

    @Autowired
    private SysLogDao sysLogDao;

    @Value("${spring.application.name}")
    private String serverName;

    /**
     * 切入点SysLog
     */
    @Pointcut("@annotation(com.bright.common.SysLog)")
    public void asAnnotation() {
    }

    @Around("asAnnotation() && @annotation(sysLog)")
    public Object around(ProceedingJoinPoint pjp, SysLog sysLog) throws Throwable {
        // 执行方法之前
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ipAddress = ReqIpUtil.getIpAddress(request);
        // 执行方法
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();
        insertLog(request.getRequestURI(), startTime, endTime, ipAddress, sysLog, pjp.getArgs());
        // 执行方法之后
        return proceed;
    }

    /**
     * 插入系统日志
     *
     * @param path      接口url
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param syslog    系统日志
     * @param args      请求参数
     */
    private void insertLog(String path, long startTime, long endTime, String ipAddress, SysLog syslog, Object[] args) {
        SysLogEntity sysLogEntity = new SysLogEntity();
        sysLogEntity.setAppId(syslog.appId());
        sysLogEntity.setServerName(serverName);
        sysLogEntity.setReqPath(path);
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            Object arg = args[0];
            if (arg instanceof HttpServletRequest) {
                logger.info("param is HttpServletRequest");
            } else if (arg instanceof HttpServletResponse) {
                logger.info("param is HttpServletResponse");
            } else if (arg instanceof MultipartFile) {
                logger.info("param is MultipartFile");
            } else {
                params.append(arg);
            }
        }
        String value = JSON.toJSONString(params);
        if (value.length() > MAX_PARAM_LENGTH) {
            value = value.substring(0, MAX_PARAM_LENGTH);
        }
        sysLogEntity.setReqParams(value);
        sysLogEntity.setReqType(syslog.editType().name());
        sysLogEntity.setIsSuccess(1);
        sysLogEntity.setStartTime(startTime);
        sysLogEntity.setEndTime(endTime);
        sysLogEntity.setReqDesc(syslog.reqDesc());
        sysLogEntity.setIpAddress(ipAddress);
        sysLogDao.insert(sysLogEntity);
        logger.info("插入系统日志成功");
    }
}
