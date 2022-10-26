package com.xiaocai.processdemo2.mock;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;


import java.util.List;

/**
 * @description: Mockito的使用探索
 * 官方样例：https://github.com/hehonghui/mockito-doc-zh/blob/master/README.md#2
 * @author: xiaocai
 * @time: 2022/10/18 9:26
 */
public class MockitoDemo {

    public static void main(String[] args) {
        //如果不使用静态导入,则必须使用Mockito调用
        List mockList = Mockito.mock(List.class);
        System.out.println(mockList);

        mockList.add("one");
        //验证
        Mockito.verify(mockList).add("one");

        //测试桩
        OngoingStubbing<Object> first = Mockito.when(mockList.get(0)).thenReturn("first");
        Mockito.when(mockList.get(1)).thenThrow(new RuntimeException());
    }
}
