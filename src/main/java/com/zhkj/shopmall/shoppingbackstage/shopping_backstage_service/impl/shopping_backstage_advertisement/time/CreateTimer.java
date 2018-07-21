package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_advertisement.time;


import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置类
 */
@Configuration
public class CreateTimer {

//    /**
//     * 要执行的任务
//     * UpdateAdvertisementEndTime 自己定义的类
//     * @return
//     */
//    @Bean(name = "firstJobDetail")
//    public MethodInvokingJobDetailFactoryBean firstJobDetail(UpdateAdvertisementTime updateAdvertisementTime){
//        MethodInvokingJobDetailFactoryBean jobDetail  = new MethodInvokingJobDetailFactoryBean();
//        jobDetail .setConcurrent(false);
//        jobDetail .setName("see_endTime");
//        jobDetail .setGroup("see_Mysql_advertisement");
//        jobDetail .setTargetObject(updateAdvertisementTime);
//        jobDetail .setTargetMethod("updateAdvertisement");
//        return jobDetail ;
//    }
//
////    /**
//     * 出发器
//     *  执行任务触发的条件
//     * @return
//     */
//    @Bean(name = "firstTrigger")
//    public SimpleTriggerFactoryBean firstTrigger(JobDetail firstJobDetail){
//        SimpleTriggerFactoryBean   trigger  = new SimpleTriggerFactoryBean ();
//        trigger.setJobDetail(firstJobDetail);
//        trigger.setRepeatInterval(1000 * 60 * 2);
//        trigger.setName("EndTime");
//        return trigger;
//    }


//    /**
//     * 定义任务
//     * 自定义方法
//     * @param updateAdvertisementTime
//     * @return
//     */
//    @Bean(name = "secondJobDetail")
//    public MethodInvokingJobDetailFactoryBean secondJobDetail(UpdateAdvertisementTime updateAdvertisementTime){
//        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
//        jobDetailFactoryBean.setConcurrent(false);
//        jobDetailFactoryBean.setName("see_startTime");
//        jobDetailFactoryBean.setGroup("see_mysql_advertisement");
//        jobDetailFactoryBean.setTargetObject(updateAdvertisementTime);
//        jobDetailFactoryBean.setTargetMethod("updateAvertisementStratTime");
//        return jobDetailFactoryBean;
//
//    }

//    /**
//     * 触发条件
//     * 执行任务触发的条件
//     * @return
//     */
//    @Bean(name = "secondTrigger")
//    public CronTriggerFactoryBean  secondTrigger(JobDetail secondJobDetail){
//        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
//        cronTriggerFactoryBean.setJobDetail(secondJobDetail);
//        cronTriggerFactoryBean.setCronExpression("0 */2 * * * ?");
//        // 触发器的名称
//        cronTriggerFactoryBean.setName("StartTime");
//        return cronTriggerFactoryBean;
//    }





//    @Bean(name = "scheduler")
//    public SchedulerFactoryBean schedulerFactoryBean(Trigger firstTrigger,Trigger secondTrigger){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        //QuartzScheduler 启动时更新已存在的Job
//        schedulerFactoryBean.setOverwriteExistingJobs(true);
//        //延迟 1 秒启动
//        schedulerFactoryBean.setStartupDelay(1);
//        //触发器
//        schedulerFactoryBean.setTriggers(firstTrigger,secondTrigger);
//        return schedulerFactoryBean;
//    }
}
