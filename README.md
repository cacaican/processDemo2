# processDemo2
学习工作流和springBatch时候的一个小demo
该项目主要有一下几个部分

1.使用springboot集成的activity6 创建了一个启动流程，详见com.xiaocai.processdemo2.activity包中的数据,分两种情况实现了流程定义，分别是
  1) com.xiaocai.processdemo2.activity.service.processDemo2类中，手动创建ProcessEngineConfiguration、processEngine、RepositoryService、deploy、processInstance 再调用各自的对应方法走完各个流程
  
  2）另一个是com.xiaocai.processdemo2.activity.service.ActivityConsumerServiceImpl类中，直接使用springboot集成activity6的配置，读取配置文件src/main/resources/processes/MyProcess.bpmn中
  的流程文件，挨个便利进行流程操作
  
2.根据网上教程测试了一下java代码中打开浏览器访问指定网址的方法，详见com.xiaocai.processdemo2.base.RunExploreInWindows类。基本上是通过windows操作系统或者jsk提供的api进行调用的 

3.测试了一下springBatch的一些使用：
  1）com.xiaocai.processdemo2.batch.config.HelloWorldJobConfig类中定义了 job、step、reader、processor、writer
  批处理流程大致过程就是 定义处理任务job，一个任务由一个或多个步骤step构成，在step中根据需要会定义数据读取reader，处理类processor以及writer数据输出 。再在springboot中将其装配好即可
  至于job任务的调度器，这里用的是springboot自带的JobLauncherTestUtils，而我们实际业务中一般会结合定时任务quatz 或者sprigSchedule进行任务调度
  
  2）测试的时候springbatch有一些坑，主要是使用数据库存储时候的表配置，一些包的依赖
  
4.简单写了些jsp页面，做了下jsp的集成：详见com.xiaocai.processdemo2.jsp  没学习完，好多指令没来得及一个一个测试

5.简单测试了下java后端使用mock，一个是引入mock。js ，一个是使用mockito框架，分别见com.xiaocai.processdemo2.mock.MockDemo 与  com.xiaocai.processdemo2.mock.MockitoDemo
  
6.简单测试了下opencv的使用：做了下根据图片进行人脸识别的测试，以及图片转灰度图的测试：详见：com.xiaocai.processdemo2.TestOpenCv
  问题主要在于opencv的引入，需要手动读取opencv_java库，然后调用的时候比较麻烦
