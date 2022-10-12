package com.xiaocai.processdemo2.activity.controller;



import com.xiaocai.processdemo2.activity.service.ActivityConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/10/12 9:23
 */

@RestController
@RequestMapping("/test")
public class ActivityConsumerController {

    @Autowired
    private ActivityConsumerService activityService;
    /**
     * 流程demo
     * @return
     */
    @RequestMapping(value="/activityDemo",method= RequestMethod.GET)
    public boolean startActivityDemo(){
        return activityService.startActivityDemo();
    };

}