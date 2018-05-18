<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>mail_manage.jsp</title>

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
    <table id="dg" title="站内邮件管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/mail/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">标题</th>
            <th field="voSender" width="50">发送者</th>
            <th field="voReceiver" width="50">接收者</th>
            <th field="time" width="50">发送时间</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyMail()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showMail()">查看详细信息</a>
</div>

<div id="showMailDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showMailDialog-buttons">
    <h5>标题：</h5>
    <div id="name_content"></div>
    <h5>发送者：</h5>
    <div id="voSender_content"></div>
    <h5>接收者：</h5>
    <div id="voReceiver_content"></div>
    <h5>正文：</h5>
    <div id="content_content"></div>
    <h5>发布时间：</h5>
    <div id="time_content"></div>
</div>

<div id="showMailDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showMailDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
