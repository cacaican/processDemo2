package com.xiaocai.processdemo2.base;

import java.awt.*;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Map;

/**
 * @description: java 程序调用浏览器打开网页的五种方法
 * 参考教程：https://blog.csdn.net/xingbaozhen1210/article/details/81078101
 * @author: xiaocai
 * @time: 2022/10/17 14:27
 */
public class RunExploreInWindows {

    public static void main(String[] args) throws Exception {

//         获取当前运行进程。然后执行各个操作系统提供的api接口：window下不仅能打开网页，也能打开文件资源管理器中的文件：不过要注意路径不能\\需要用/
//        browse1("www.baidu.com");
//        browse1("F:/工作文件/新核心工作文件/新核心相关文档/保单信息(1)(1).xls");

        //使用java自带的deskTop类进行浏览，不仅能打开浏览器，还能访问文件
//        browse2("F:/工作文件/新核心工作文件/新核心相关文档/保单信息(1)(1).xls");

        browse3("www.baidu.com");


    }

    private static void browse1(String url) throws Exception {
        String osName = System.getProperty("os.name", "");// 获取操作系统的名字

        if (osName.startsWith("Windows")) {// windows
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else if (osName.startsWith("Mac OS")) {// Mac
            Class fileMgr = Class.forName("com.apple.eio.FileManager");
            Method openURL = fileMgr.getDeclaredMethod("openURL", String.class);
            openURL.invoke(null, url);
        } else {// Unix or Linux
            String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++) { // 执行代码，在brower有值后跳出，
                // 这里是如果进程创建成功了，==0是表示正常结束。
                if (Runtime.getRuntime().exec(new String[]{"which", browsers[count]}).waitFor() == 0) {
                    browser = browsers[count];
                }
            }

            if (browser == null) {
                throw new RuntimeException("未找到任何可用的浏览器");
            } else {// 这个值在上面已经成功的得到了一个进程。
                Runtime.getRuntime().exec(new String[]{browser, url});
            }
        }
    }

    /**
     * @title 使用默认浏览器打开
     * @author Xingbz
     */
    private static void browse2(String url) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI(url);
            desktop.browse(uri);
        }
    }

    /**
     * @title 通过获取环境变量的浏览器路径, 然后启动浏览器
     * @author Xingbz
     */
    private static void browse3(String url) throws Exception {
//        String firefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
        System.out.println("value");

        Map map = System.getenv();
        for (Object key : map.keySet()) {
            String value = (String) map.get(key);
            if (value.contains("firefox.exe")) {
//                firefox = value;
                System.out.println(value);
                break;
            }
        }
//        Runtime.getRuntime().exec(new String[]{firefox, url});
    }

    /**
     * @title 启用cmd运行IE的方式来打开网址
     * @author Xingbz
     */
    private static void browse4(String url) throws Exception {
        Runtime.getRuntime().exec("cmd /c start " + url);//启用cmd运行默认浏览器
//        Runtime.getRuntime().exec("cmd /c start iexplore " + url);//启用cmd运行IE
    }

    /**
     * @title 利用java.lang.ProcessBuilder类创建系统进程的能力，通过浏览器地址启动浏览器，并将网址作为参数传送给浏览器。
     * ProcessBuilder类是J2SE1.5在java.lang中新添加的一个新类，此类用于创建操作系统进程，它提供一种启动和管理进程（也就是应用程序）的方法。
     * @author Xingbz
     */
    private static void browse5(String url) throws Exception {
        ProcessBuilder proc = new ProcessBuilder("C:\\Program Files\\Mozilla Firefox\\firefox.exe",
                url);
        proc.start();
    }
}