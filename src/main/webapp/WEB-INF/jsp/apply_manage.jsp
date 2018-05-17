<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="酒店管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/hotel/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">酒店名称</th>
            <th field="addr" width="50">酒店地址</th>
            <th field="score" width="50">酒店评分</th>
            <th field="star" width="50">酒店星级</th>
            <th field="phone" width="50">联系方式</th>
            <th field="info" width="50">酒店简介</th>
            <th field="voImg" width="50">酒店图片</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newHotel()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editHotel()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyHotel()">删除</a>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showHotel()">查看详细信息</a>--%>
    <%--<label>按年度查询</label>--%>
    <%--<input id="Book_searchInput"--%>
    <%--name="year"--%>
    <%--class="easyui-combobox"--%>
    <%--data-options="--%>
    <%--valueField:'ddlcode',--%>
    <%--textField:'ddlname',--%>
    <%--width:300,--%>
    <%--url:'${pageContext.request.contextPath}/systemddl/list/year'" />--%>
</div>
<div id="HotelDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Hotel-buttons">
    <div class="ftitle">酒店信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>酒店名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>酒店地址</label><div>&nbsp;</div>
            <input type="text" name="addr" class="plainText">
        </div>
        <div class="fitem">
            <label>酒店评分</label><div>&nbsp;</div>
            <input type="text" name="score" class="plainText">
        </div>
        <div class="fitem">
            <label>酒店星级</label><div>&nbsp;</div>
            <input type="text" name="star" class="plainText">
        </div>
        <div class="fitem">
            <label>联系方式</label><div>&nbsp;</div>
            <input type="text" name="phone" class="plainText">
        </div>
        <div class="fitem">
            <label>酒店图片</label><div>&nbsp;</div>
            <input type="file" name="img_file" class="plainText">
        </div>
        <div class="fitem">
            <label>酒店简介</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="500字以内"></textarea>
        </div>
    </form>
</div>
<div id="Hotel-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveHotel()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#HotelDialog').dialog('close')">取消</a>
</div>

<div id="showHotelDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showHotelDialog-buttons">
    <img id="att_img"/>
</div>

<div id="showHotelDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showHotelDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
