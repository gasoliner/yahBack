<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>apply_manage.jsp</title>
    <link rel="stylesheet" href="/ui/kindeditor/themes/default/default.css" />
    <script charset="utf-8" src="/ui/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="/ui/kindeditor/lang/zh-CN.js"></script>
    <jsp:include page="header.jsp"/>
    <script type="text/javascript">
        $(function () {
            KindEditor.ready(function(K) {
                var editor = K.create('#pass_email_content', {
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
    <table id="dg" title="应聘信息管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/apply/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="voRid" width="50">应聘岗位</th>
            <th field="voMid" width="50">姓名</th>
            <%--<th field="member.age" width="50">年龄</th>--%>
            <%--<th field="member.university" width="50">毕业大学</th>--%>
            <%--<th field="member.idnumber" width="50">身份证号</th>--%>
            <th field="var" width="50">状态</th>
            <th field="voResume" width="50">简历</th>
            <shiro:hasRole name="2">
                <th field="action" width="50">操作</th>
            </shiro:hasRole>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newApply()">新建</a>--%>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editApply()">编辑</a>--%>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyApply()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showApplyMember()">查看个人详细信息</a>
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

<div id="MailDialog" class="easyui-dialog" style="width:800px;height:650px;padding:10px 20px"
     closed="true" buttons="#Mail-buttons">
    <div class="ftitle">面试邀约邮件填写</div>
    <form id="fm" method="post" >
        <div class="fitem">
            <label>标题</label><div>&nbsp;</div>
            <input type="text" id="pass_email_name" placeholder="100字以内" class="plainText">
        </div>
        <input type="hidden" id="receiveId">
        <div class="fitem">
            <label>正文</label><div>&nbsp;</div>
            <textarea id="pass_email_content" style="height: 550px;width: 500px;"></textarea>
        </div>
    </form>
</div>
<div id="Mail-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="sendPassMail()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#MailDialog').dialog('close')">取消</a>
</div>

<div id="showApplyDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#showApplyDialog-buttons">
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

<div id="showApplyDialog-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#showApplyDialog').dialog('close')">好的</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
