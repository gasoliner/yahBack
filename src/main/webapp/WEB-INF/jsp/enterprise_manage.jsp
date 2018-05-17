<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="企业管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/enterprise/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">名称</th>
            <th field="nature" width="50">企业性质</th>
            <th field="scale" width="50">企业规模</th>
            <th field="website" width="50">企业站点</th>
            <th field="trade" width="50">经营行业</th>
            <th field="addr" width="50">企业地址</th>
            <th field="phone" width="50">联系方式</th>
            <th field="email" width="50">官方邮箱</th>
            <th field="info" width="50">企业简介</th>
            <th field="voImg" width="50">企业图片</th>
            <th field="voIslock" width="50">操作</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newEnterprise()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editEnterprise()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyEnterprise()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showEnterprise()">查看详细信息</a>
</div>
<div id="EnterpriseDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Enterprise-buttons">
    <div class="ftitle">企业信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>企业性质</label><div>&nbsp;</div>
            <input type="text" name="nature" class="plainText">
        </div>
        <div class="fitem">
            <label>企业规模</label><div>&nbsp;</div>
            <input type="text" name="scale" class="plainText">
        </div>
        <div class="fitem">
            <label>企业站点</label><div>&nbsp;</div>
            <input type="text" name="website" class="plainText">
        </div>
        <div class="fitem">
            <label>经营行业</label><div>&nbsp;</div>
            <input type="text" name="trade" class="plainText">
        </div>
        <div class="fitem">
            <label>企业地址</label><div>&nbsp;</div>
            <input type="text" name="addr" class="plainText">
        </div>
        <div class="fitem">
            <label>联系方式</label><div>&nbsp;</div>
            <input type="text" name="phone" class="plainText">
        </div>
        <div class="fitem">
            <label>官方邮箱</label><div>&nbsp;</div>
            <input type="text" name="email" class="plainText">
        </div>
        <div class="fitem">
            <label>企业图片</label><div>&nbsp;</div>
            <input type="file" name="img_file" class="plainText">
        </div>
        <div class="fitem">
            <label>企业简介</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="1000字以内"></textarea>
        </div>
    </form>
</div>
<div id="Enterprise-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEnterprise()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#EnterpriseDialog').dialog('close')">取消</a>
</div>

<div id="showEnterpriseDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showEnterpriseDialog-buttons">
    <img id="att_img"/>
</div>

<div id="showEnterpriseDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showEnterpriseDialog').dialog('close')">好的</a>
</div>

<div id="showEnterpriseInfoDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showEnterpriseInfoDialog-buttons">
    <h5>名称：</h5>
    <div id="name_content"></div>
    <h5>企业性质：</h5>
    <div id="nature_content"></div>
    <h5>企业规模：</h5>
    <div id="scale_content"></div>
    <h5>企业站点：</h5>
    <div id="website_content"></div>
    <h5>经营行业：</h5>
    <div id="trade_content"></div>
    <h5>企业地址：</h5>
    <div id="addr_content"></div>
    <h5>联系方式：</h5>
    <div id="phone_content"></div>
    <h5>官方邮箱：</h5>
    <div id="email_content"></div>
    <h5>企业图片：</h5>
    <div id="img_content"></div>
    <h5>企业简介：</h5>
    <div id="info_content"></div>
</div>

<div id="showEnterpriseInfoDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showEnterpriseInfoDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
