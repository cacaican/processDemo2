package com.xiaocai.processdemo2.mock;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.script.JavaScriptEngine;
import cn.hutool.script.ScriptUtil;

import javax.script.ScriptException;

/**
 * @description: java后端使用mock.js
 * 参考资料：https://blog.csdn.net/Kun_lei/article/details/124839070
 * @author: xiaocai
 * @time: 2022/10/18 8:29
 */
public class MockDemo {

    // Java 测试Demo
    public static void main(String[] args) throws ScriptException {
        // 获取JS引擎
        JavaScriptEngine scriptEngine = ScriptUtil.getJavaScriptEngine();
        // 引用Mock.js文件
//        String url = "mock.js文件路径";
        String url = "E:\\workspace\\GitHub\\processDemo2\\src\\main\\resources\\mock\\mock.js";


        String mockJs = FileUtil.readString(url, CharsetUtil.UTF_8);
        scriptEngine.eval(mockJs);
	/*
		此处为生成相应数据代码
	*/
        //属性值是字符串 String
        for (int i = 0; i < 3; i++) {

            /*
1.'name|min-max': string
通过重复 string 生成一个字符串，重复次数大于等于 min，小于等于 max。

2.'name|count': string
通过重复 string 生成一个字符串，重复次数等于 count。*/
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|1-3':'张三'}) )"));

        }
//属性值是数字 Number
        for (int i = 0; i < 3; i++) {

            /*
1.'name|+1': number
属性值自动加 1，初始值为 number。

2.'name|min-max': number
生成一个大于等于 min、小于等于 max 的整数，属性值 number 只是用来确定类型。

3.'name|min-max.dmin-dmax': number
生成一个浮点数，整数部分大于等于 min、小于等于 max，小数部分保留 dmin 到 dmax 位
             */
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|+1':1}) )"));
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|10-30':1}) )"));
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|10-29.1-2':1.2}) )"));
        }

        //属性值是布尔型 Boolean
        for (int i = 0; i < 3; i++) {

            /*
1.'name|1': boolean
随机生成一个布尔值，值为 true 的概率是 1/2，值为 false 的概率同样是 1/2。

2.'name|min-max': value
随机生成一个布尔值，值为 value 的概率是 min / (min + max)，值为 !value 的概率是 max / (min + max)。
             */
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|1':true}) )"));
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|1-10':true}) )"));
        }

        //属性值是布尔型 Boolean
        for (int i = 0; i < 3; i++) {

            /*
1.'name|count': object
从属性值 object 中随机选取 count 个属性。

2.'name|min-max': object
从属性值 object 中随机选取 min 到 max 个属性。
             */
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|1':{a:1,b:2,c:3,d:4}}) )"));
            System.out.println(scriptEngine.eval("JSON.stringify( Mock.mock({'name|1-2':{a:1,b:2,c:3,d:4}}) )"));

        }

    }

}
