<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>

    <link rel="stylesheet" href="/ui/kindeditor/themes/default/default.css" />
    <script charset="utf-8" src="/ui/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="/ui/kindeditor/lang/zh-CN.js"></script>

    <jsp:include page="header.jsp"/>

    <script type="text/javascript">
        $(function () {
            KindEditor.ready(function(K) {
                var editor = K.create('#content', {
                    cssPath : '/ui/kindeditor/plugins/code/prettify.css',
                    allowFileManager : true,
                    resizeType:0,
                    langType : 'zh-CN',
                    allowImageUpload:false,
                    items:[
                        'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|',
                        'table', 'hr', 'emoticons', 'pagebreak',
                        'anchor', 'link', 'unlink', '|', 'about'
                    ],
                    afterBlur:function(){this.sync();}
                });
            });
        });
    </script>
</head>
<body>
<div align="center">
    <table id="dg" title="招聘会管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/jobfair/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="voEid" width="50">发布企业</th>
            <th field="name" width="50">标题</th>
            <%--<th field="content" width="50">正文</th>--%>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newJobfair()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editJobfair()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyJobfair()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showJobfair()">查看详细信息</a>
</div>
<div id="JobfairDialog" class="easyui-dialog" style="width:800px;height:650px;padding:10px 20px"
     closed="true" buttons="#Jobfair-buttons">
    <div class="ftitle">招聘会信息填写</div>
    <form id="fm" method="post" >
        <div class="fitem">
            <label>标题</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>正文(建议用word编辑，然后复制到本编辑器中做微调)</label><div>&nbsp;</div>
            <textarea id="content" name="content" style="height: 550px;width: 500px;"></textarea>
        </div>
    </form>
</div>
<div id="Jobfair-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveJobfair()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#JobfairDialog').dialog('close')">取消</a>
</div>

<div id="showJobfairDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showJobfairDialog-buttons">
    <h5>发布企业：</h5>
    <div id="eid_content"></div>
    <h5>标题：</h5>
    <div id="name_content"></div>
    <h5>正文：</h5>
    <div id="content_content"></div>
</div>

<div id="showJobfairDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showJobfairDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
