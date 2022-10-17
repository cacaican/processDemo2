package com.xiaocai.processdemo2;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/10/14 16:33
 */
public class Test {

    public static void main(String[] args) {
        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; ++i) {
            System.out.println(i + "    " + (char)i);
        }

        String a ="sdf";//半角输入
        String b ="ｓｄｆ";//半角输入

        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(a.length());
        System.out.println(b.length());
    }



}
