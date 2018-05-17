<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="招聘信息管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/recruit/list',
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
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRecruit()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRecruit()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRecruit()">删除</a>
</div>
<div id="RecruitDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Recruit-buttons">
    <div class="ftitle">招聘信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>标题</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>发布企业&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="eid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'eid',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/enterprise/ddllist'" />
        </div>
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
    <img id="att_img"/>
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
