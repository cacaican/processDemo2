package com.xiaocai.processdemo2;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {/*DataSourceAutoConfiguration.class,*/ SecurityAutoConfiguration.class})
@ComponentScan(basePackages={"com.xiaocai.processdemo2.activity"})
@ComponentScan(basePackages={"com.xiaocai.processdemo2.jsp"})
public class ProcessDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProcessDemo2Application.class, args);
    }

}
