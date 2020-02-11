<%--
  Created by IntelliJ IDEA.
  User: zzq52
  Date: 2020/2/11
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>SUCCESS!!</h1>

<%-- value里边写的就是ognl表达式 --%>
<%-- 1. 从根区取数据, 可以直接取出对象的字段, 只能取栈顶的元素 --%>
<s:property value="name"/><br>
<s:property value="price"/><br>

<%-- 2. 从非根区取数据("#" + key值), 注意观察debug信息中的值栈的结构 --%>
<%-- 取直接put进去的数据(往request域中存的数据) --%>
<s:property value="#reqName"/><br>
<%-- 取session域中的数据 --%>
<s:property value="#session.sessionName"/><br>
<%-- 取application域中的数据 --%>
<s:property value="#application.appName"/><br>

<%-- 3. 在页面中使用ognl调用方法 --%>
<s:property value="'hello'.length()"/><br>
<%-- 默认是访问不到静态成员的, 想要访问, 需要在struts.xml中配置一个常量 --%>
<s:property value="@java.lang.Math@random()"/><br>

<%-- 通过这个标签可以在页面中看到值栈的数据 --%>
<s:debug></s:debug>

</body>
</html>
