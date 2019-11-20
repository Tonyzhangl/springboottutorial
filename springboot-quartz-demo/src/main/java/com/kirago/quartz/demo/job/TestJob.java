package com.kirago.quartz.demo.job;

import cn.hutool.core.date.DateUtil;
import com.kirago.quartz.demo.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

@Slf4j
public class TestJob implements BaseJob {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Test 执行时间:{}", DateUtil.now());
    }
}
