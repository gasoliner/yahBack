<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="会员管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/member/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="mid" width="50">会员编号</th>
            <th field="name" width="50">名字</th>
            <th field="phone" width="50">联系方式</th>
            <th field="email" width="50">邮箱地址</th>
            <th field="age" width="50">年龄</th>
            <th field="university" width="50">毕业大学</th>
            <th field="point" width="50">特长</th>
            <th field="idnumber" width="50">身份证号</th>
            <th field="voResume" width="50">简历查看</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newMember()">新建</a>--%>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editMember()">编辑</a>--%>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyMember()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showMember()">查看详情</a>
</div>


<div id="showMemberDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showMemberDialog-buttons">
    <h5>会员编号：</h5>
    <div id="mid_content"></div>
    <h5>名字：</h5>
    <div id="name_content"></div>
    <h5>联系方式：</h5>
    <div id="phone_content"></div>
    <h5>邮箱地址：</h5>
    <div id="email_content"></div>
    <h5>年龄：</h5>
    <div id="age_content"></div>
    <h5>毕业大学：</h5>
    <div id="university_content"></div>
    <h5>特长：</h5>
    <div id="point_content"></div>
    <h5>身份证号：</h5>
    <div id="idnumber_content"></div>
    <h5>简历查看：</h5>
    <div id="voResume_content"></div>
</div>

<div id="showMemberDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showMemberDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
