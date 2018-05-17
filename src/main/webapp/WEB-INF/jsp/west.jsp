<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .menu-last{
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;height: 350px;border: 0px;">
    <div title="招聘相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('招聘信息管理','recruit_manage')">招聘信息管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('应聘信息管理','apply_manage')">应聘信息管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('招聘会管理','jobfair_manage')">招聘会管理</a>
        </div>
    </div>
    <div title="用户相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('未通过审批企业管理','enterprise_lock_manage')">未通过审批企业管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('企业管理','enterprise_manage')">企业管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('会员管理','member_manage')">会员管理</a>
        </div>
    </div>
    <div title="站点相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('新闻管理','news_manage')">新闻管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('面试技巧管理','interviewskill_manage')">面试技巧管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('岗位留言管理','special_manage')">岗位留言管理</a>
        </div>
    </div>
    <div title="系统相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('岗位类别管理','category_manage')">岗位类别管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('站内邮箱管理','hotel_kind_manage')">站内邮箱管理</a>
        </div>
    </div>
    <div title="个人信息管理" iconCls="icon-mini-edit" selected="true" style="padding:10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('个人信息','personalInfo')">个人信息</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('密码修改','')">密码修改</a>
        </div>
    </div>
</div>
</body>
