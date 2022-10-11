package com.xiaocai.processdemo2.batch.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @description: 继承springBatch默认配置类
 *https://zhuanlan.zhihu.com/p/91691608
 * 通过添加这个注解会需要很多操作。下面是@EnableBatchProcessing创建的概述:
 * 这个类中会判断数据库驱动还是内存映射驱动，并且实例化各个组件，例如以下几个
 *
 * JobRepository (bean名称 "jobRepository")
 * JobLauncher (bean名称 "jobLauncher")
 * JobRegistry (bean名称 "jobRegistry")
 * JobExplorer (bean名称 "jobExplorer")
 * PlatformTransactionManager (bean名称 "transactionManager")
 * JobBuilderFactory (bean名称"jobBuilders")，它可以方便地防止您必须将作业存储库注入到每个Job(作业)中
 * StepBuilderFactory (bean名称 "stepBuilders")，以方便您避免将作业存储库和事务管理器注入到每个Step(步骤)中
 * 为了使Spring Batch使用基于Map的JobRepository，我们需要扩展DefaultBatchConfigurer。重写setDataSource()方法以不设置DataSource。这将导致自动配置使用基于Map的JobRepository。
 * @author: xiaocai
 * @time: 2022/10/11 15:22
 */
@Configuration//实例化本类中定义的bean
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {




    @Override
    public void setDataSource(DataSource dataSource) {
        // initialize will use a Map based JobRepository (instead of database)
    }
}
