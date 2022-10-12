package com.xiaocai.processdemo2.activity.service;

import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.impl.form.DateFormType;
import org.activiti.engine.impl.form.StringFormType;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 内存中处理工作流简单样例，不依赖springboot
 * 参考地址：https://blog.csdn.net/java_study_/article/details/104909285?spm=1001.2014.3001.5502
 * @author: xiaocai
 * @time: 2022/10/12 14:41
 */
public class processDemo2 {

    private static final Logger logger = LoggerFactory.getLogger(processDemo2.class);
    private static String filePath = "MyProcess2.bpmn";

    public static void main(String[] args) throws ParseException, IOException {

        // ClassPathResource 读取文件
        ClassPathResource classPathResource = new ClassPathResource("ReadResourceFile.txt");
        // 获取输入流
        try (InputStream inputStream = classPathResource.getInputStream()) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //step 1：创建流程引擎
        ClassPathResource Resource = new ClassPathResource("/processes/MyProcess2.bpmn");
        System.out.println("-----------------------------"+Resource.getURL().getPath());

        ProcessEngineConfiguration engineConfiguration
                = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
        ProcessEngine processEngine = engineConfiguration.buildProcessEngine();
        logger.info("流程引擎名称[{}],版本[{}]",processEngine.getName(),processEngine.VERSION);

        //step2: 部署流程定义文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().addClasspathResource(Resource.getPath()).deploy();


        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        ProcessDefinition processDefinition = processDefinitionQuery.deploymentId(deploy.getId()).singleResult();

        //step 3： 启动流程
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(processDefinition.getId());
        logger.info("流程启动{}",processInstance.getProcessDefinitionKey());
        //step4 ： 处理流程任务

        //4.处理流程任务
        Scanner scanner = new Scanner(System.in);

        while (processInstance!=null && !processInstance.isEnded()){
            TaskService taskService = processEngine.getTaskService();
            List<Task> list = taskService.createTaskQuery().list();
            for (Task task : list){
                TaskFormData taskFormData = processEngine.getFormService().getTaskFormData(task.getId());
                List<FormProperty> formProperties = taskFormData.getFormProperties();
                Map<String,Object> map = new HashMap();
                for (FormProperty pro:formProperties) {
                    String line = null;
                    if(StringFormType.class.isInstance(pro.getType())){
                        logger.info("请输入：{}",pro.getName());
                        line = scanner.nextLine();
                        logger.info("您输入的是：{}",line);
                        map.put(pro.getId(),line);
                    }else if (DateFormType.class.isInstance(pro.getType())){
                        logger.info("请输入：{}，格式{yyyy-MM-dd}",pro.getName());
                        line = scanner.nextLine();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
                        Date date = simpleDateFormat.parse(line);
                        map.put(pro.getId(),date);
                    }else{
                        logger.info("类型暂不支持{}",pro.getType());
                    }
                }
                taskService.complete(task.getId(),map);
                //更新任务节点
                processInstance = processEngine
                        .getRuntimeService()
                        .createProcessInstanceQuery()
                        .processInstanceId(processInstance.getId())
                        .singleResult();
            }
        }
        logger.info("结束程序------------");
        //step 5 : 更新任务节点
    }
}
