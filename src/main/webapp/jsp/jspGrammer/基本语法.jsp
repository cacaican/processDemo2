<%@ page import="javafx.scene.shape.Circle" %><%--
  Created by IntelliJ IDEA.
  User: xiaocai
  Date: 2022/10/14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp基本语法</title>
</head>
<body>
参考资料:https://www.runoob.com/jsp/jsp-syntax.html
<%--html中水平划分线--%>
<hr>
<%--带文字的水平划分线--%>
<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    带文字的水平划分线
</div>


<%--
可以通过
<% 代码片段 %>
或者
<jsp:scriptlet>
   代码片段
</jsp:scriptlet>
两种方式定义jsp代码
--%>

<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    JSP声明变量\方法测试
</div>
<%--
可以通过
<%! declaration; [ declaration; ]+ ... %>
或者
<jsp:declaration>
   代码片段
</jsp:declaration>
两种方式声明jsp变量
--%>
<%! int i = 0; %>
<%! int a, b, c; %>
<%! Circle circle = new Circle(2.0); %>

<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    JSP表达式测试
</div>
<%--
可以通过
<%= 表达式 %>
或者
<jsp:expression>
   表达式
</jsp:expression>
两种方式声明jsp表达式
--%>
<p>
    今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
</p>


<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    JSP注释
</div>
<%--
<%-- 注释 --%>   JSP注释，注释内容不会被发送至浏览器甚至不会被编译
<!-- 注释 -->    HTML注释，通过浏览器查看网页源代码时可以看见注释内容
<%--<\%    代表静态 <%常量
 %\>  代表静态 %> 常量
\'	在属性中使用的单引号
\"	在属性中使用的双引号
--%>


<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    JSP指令
</div>
<%--JSP指令
JSP指令用来设置与整个JSP页面相关的属性。
JSP指令语法格式：
<%@ directive attribute="value" %>
指令	描述
<%@ page ... %>	定义页面的依赖属性，比如脚本语言、error页面、缓存需求等等
<%@ include ... %>	包含其他文件
<%@ taglib ... %>	引入标签库的定义，可以是自定义标签
--%>


<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    JSP行为
</div>
<%--
JSP行为标签使用XML语法结构来控制servlet引擎。它能够动态插入一个文件，重用JavaBean组件，引导用户去另一个页面，为Java插件产生相关的HTML等等。
行为标签只有一种语法格式，它严格遵守XML标准：
<jsp:action_name attribute="value" />
行为标签基本上是一些预先就定义好的函数，下表罗列出了一些可用的JSP行为标签：：

语法	描述
jsp:include	用于在当前页面中包含静态或动态资源
jsp:useBean	寻找和初始化一个JavaBean组件
jsp:setProperty	设置 JavaBean组件的值
jsp:getProperty	将 JavaBean组件的值插入到 output中
jsp:forward	从一个JSP文件向另一个文件传递一个包含用户请求的request对象
jsp:plugin	用于在生成的HTML页面中包含Applet和JavaBean对象
jsp:element	动态创建一个XML元素
jsp:attribute	定义动态创建的XML元素的属性
jsp:body	定义动态创建的XML元素的主体
jsp:text	用于封装模板数据

--%>

<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    隐含对象
</div>
<%--
JSP隐含对象
JSP支持九个自动定义的变量，江湖人称隐含对象。这九个隐含对象的简介见下表：

对象	描述
request	HttpServletRequest类的实例
response	HttpServletResponse类的实例
out	PrintWriter类的实例，用于把结果输出至网页上
session	HttpSession类的实例
application	ServletContext类的实例，与应用上下文有关
config	ServletConfig类的实例
pageContext	PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问
page	类似于Java类中的this关键字
exception	exception 类的对象，代表发生错误的 JSP 页面中对应的异常对象
--%>


<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    判断语句
</div>

<%--if 实例--%>
<%! int day = 3; %>
<h3>IF...ELSE 实例</h3>
<% if (day == 1 || day == 7) { %>
<p>今天是周末</p>
<% } else { %>
<p>今天不是周末</p>
<% } %>

<%--switch 实例--%>
<h3>SWITCH...CASE 实例</h3>
<%
    switch(day) {
        case 0:
            out.println("星期天");
            break;
        case 1:
            out.println("星期一");
            break;
        case 2:
            out.println("星期二");
            break;
        case 3:
            out.println("星期三");
            break;
        case 4:
            out.println("星期四");
            break;
        case 5:
            out.println("星期五");
            break;
        default:
            out.println("星期六");
    }
%>

<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
    循环语句
</div>
<%! int fontSize; %>
<h3>For 循环实例</h3>
<%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
<font color="green" size="<%= fontSize %>">
    菜鸟教程
</font><br />
<%}%>


<h3>While 循环实例</h3>
<%while ( fontSize <= 5){ %>
<font color="green" size="<%= fontSize %>">
    菜鸟教程
</font><br />
<%fontSize++;%>
<%}%>


<hr style="top: 13px; position: relative;">
<div style="position: relative; left: 36%; top: -18px; height: 22px; width: 85px; text-align: center; background-color: white; color: #66b7ff; font-size: 14px; cursor: pointer;">
   字面量
</div>

<%--
JSP运算符
JSP支持所有Java逻辑和算术运算符。

下表罗列出了JSP常见运算符，优先级从高到底：

类别	操作符	结合性
后缀	() [] . (点运算符)	左到右
一元	++ - - ! ~	右到左
可乘性	* / % 	左到右
可加性	+ - 	左到右
移位	>> >>> <<  	左到右
关系	> >= < <=  	左到右
相等/不等	== != 	左到右
位与	& 	左到右
位异或	^ 	左到右
位或	| 	左到右
逻辑与	&& 	左到右
逻辑或	|| 	左到右
条件判断	?: 	右到左
赋值	= += -= *= /= %= >>= <<= &= ^= |= 	右到左
逗号 	, 	左到右

JSP语言定义了以下几个字面量：

布尔值(boolean)：true 和 false;
整型(int)：与 Java 中的一样;
浮点型(float)：与 Java 中的一样;
字符串(string)：以单引号或双引号开始和结束;
Null：null。

--%>


</body>
</html>
