<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>企业注册</title>

    <link rel="stylesheet" type="text/css" href="/ui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="/ui/custom.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/custom.js"></script>
</head>
<body>
<div class="easyui-layout" style="width: 100%;height: 700px;">
    <div region="north" split="true" style="width: 100%;height: 70px;border: 0px">
        <jsp:include page="north.jsp"/>
    </div>
    <div region="center" style="padding: 5px;border-left: 0px;border-right: 0px;border-top: 0px;">

        <form id="fm" method="post" enctype="multipart/form-data">
            <div style="font-size:16px;margin-left:500px;margin-right:500px;">
                <div class="fitem">
                    <label>用户名&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="name" style="width: 100%;height: 32px"/>
                </div><br/>
                <div class="fitem">
                    <label>密码&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="password" style="width: 100%;height: 32px" type="password"/>
                </div>
                <div class="fitem">
                    <label>确认密码&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="password2" style="width: 100%;height: 32px" type="password"/>
                </div>
                <div class="fitem">
                    <label>企业性质&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="nature" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>企业规模&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="scale" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>企业站点&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="website" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>经营行业&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="trade" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>企业地址&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="addr" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>联系方式&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="phone" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>官方邮箱&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input class="easyui-textbox" name="email" style="width: 100%;height: 32px" type="text"/>
                </div>
                <div class="fitem">
                    <label>上传图片&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <input type="file" name="file" >
                </div>
                <div class="fitem">
                    <label>企业简介&nbsp;&nbsp;&nbsp;</label>
                    <div style="height: 5px;">&nbsp;</div>
                    <textarea style="width: 100%" class="textareaComment" name="info"></textarea>
                </div>
            </div>
        </form>
        <div style="margin: 20px"></div>
        <div style="width: 15%;margin: 20px auto;">
            <a class="easyui-linkbutton" iconCls="icon-ok" style="width: 100%;height: 32px;" onclick="registryEnterprise()">注 册</a>
        </div>
        已有账号，点击<a target="_blank" href="/login">登录</a>
    </div>
    <div region="south" split="true" style="width: 100%;height: 60px;border: 0px;">
        <jsp:include page="south.jsp"/>
    </div>
</div>
</body>
</html>
