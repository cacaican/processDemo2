package com.xiaocai.processdemo2.activity.service;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/10/12 9:23
 */

public interface ActivityConsumerService {
    /**
     * 流程demo
     * @return
     */
    boolean startActivityDemo();

    /**
     * 流程demo
     * @return
     */
    boolean startActivityDemo2();

}