<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
    <script type="text/javascript">
        $(function () {
            $('#searchInput').combobox({
                onChange: function(){
                    $("#dg").datagrid({
                        url:'/recruit/list/'+$("#searchInput").combobox("getValue")
                    });
                }
            });
        });
    </script>
</head>
<body>
<div align="center">
    <table id="dg" title="招聘信息管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/recruit/list/0',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">标题</th>
            <th field="voEid" width="50">发布企业</th>
            <th field="linkman" width="50">联系人</th>
            <th field="phone" width="50">联系方式</th>
            <th field="salary" width="50">薪水</th>
            <th field="publishtime" width="50">发布时间</th>
            <th field="addr" width="50">工作地址</th>
            <th field="nature" width="50">工作性质</th>
            <th field="experience" width="50">工作经验</th>
            <th field="voCid" width="50">岗位类别</th>
            <th field="education" width="50">教育程度</th>
            <th field="count" width="50">招聘人数</th>
            <th field="info" width="50">简要信息</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <shiro:hasRole name="2">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRecruit()">发布招聘</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRecruit()">编辑招聘</a>
    </shiro:hasRole>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRecruit()">删除招聘</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showRecruit()">查看详细信息</a>
    <label>按岗位类别查询</label>
    <input id="searchInput"
           name="123"
           class="easyui-combobox"
           data-options="
                           valueField:'cid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/category/ddllist'" />
</div>
<div id="RecruitDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Recruit-buttons">
    <div class="ftitle">招聘信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>标题</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <%--<div class="fitem">--%>
            <%--<label>发布企业&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>--%>
            <%--<input name="eid"--%>
                   <%--class="easyui-combobox"--%>
                   <%--data-options="--%>
                           <%--valueField:'eid',--%>
                           <%--textField:'name',--%>
                           <%--width:300,--%>
                           <%--url:'${pageContext.request.contextPath}/enterprise/ddllist'" />--%>
        <%--</div>--%>
        <div class="fitem">
            <label>联系人</label><div>&nbsp;</div>
            <input type="text" name="linkman" class="plainText">
        </div>
        <div class="fitem">
            <label>联系方式</label><div>&nbsp;</div>
            <input type="text" name="phone" class="plainText">
        </div>
        <div class="fitem">
            <label>薪水</label><div>&nbsp;</div>
            <input type="text" name="salary" class="plainText">
        </div>
        <div class="fitem">
            <label>工作地址</label><div>&nbsp;</div>
            <input type="text" name="addr" class="plainText">
        </div>
        <div class="fitem">
            <label>工作性质</label><div>&nbsp;</div>
            <input type="text" name="nature" class="plainText">
        </div>
        <div class="fitem">
            <label>工作经验</label><div>&nbsp;</div>
            <input type="text" name="experience" class="plainText">
        </div>
        <div class="fitem">
            <label>学历程度</label><div>&nbsp;</div>
            <input type="text" name="education" class="plainText">
        </div>
        <div class="fitem">
            <label>招聘人数</label><div>&nbsp;</div>
            <input type="text" name="count" class="plainText">
        </div>
        <div class="fitem">
            <label>岗位类别</label><div>&nbsp;</div>
            <input name="cid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'cid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/category/ddllist'" />        </div>
        <div class="fitem">
            <label>简要介绍</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Recruit-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRecruit()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#RecruitDialog').dialog('close')">取消</a>
</div>

<div id="showRecruitDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showRecruitDialog-buttons">

    <h5>标题：</h5>
    <div id="name_content"></div>
    <h5>发布企业：</h5>
    <div id="voEid_content"></div>
    <h5>联系人：</h5>
    <div id="linkman_content"></div>
    <h5>联系方式：</h5>
    <div id="phone_content"></div>
    <h5>薪水：</h5>
    <div id="salary_content"></div>
    <h5>发布时间：</h5>
    <div id="publishtime_content"></div>
    <h5>工作地址：</h5>
    <div id="addr_content"></div>
    <h5>工作性质：</h5>
    <div id="nature_content"></div>
    <h5>工作经验：</h5>
    <div id="experience_content"></div>
    <h5>岗位类别：</h5>
    <div id="voCid_content"></div>
    <h5>教育程度：</h5>
    <div id="education_content"></div>
    <h5>招聘人数：</h5>
    <div id="count_content"></div>
    <h5>简要信息：</h5>
    <div id="info_content"></div>
</div>

<div id="showRecruitDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showRecruitDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
