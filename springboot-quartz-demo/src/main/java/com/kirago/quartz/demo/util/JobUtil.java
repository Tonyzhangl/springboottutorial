package com.kirago.quartz.demo.util;

import com.kirago.quartz.demo.job.base.BaseJob;

public class JobUtil {

    public static BaseJob getClass(String jobName) throws Exception {

        Class<?> clazz = Class.forName(jobName);
        return (BaseJob) clazz.newInstance();
    }
}
