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
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>招聘相关管理</span>
            <ul>
                <li data-options="attributes:{'url':'recruit_manage'}">招聘信息管理</li>
                <li data-options="attributes:{'url':'apply_manage'}">应聘信息管理</li>
                <li data-options="attributes:{'url':'jobfair_manage'}">招聘会管理</li>
            </ul>
        </li>
        <shiro:hasRole name="1">
            <li>
                <span>用户相关管理</span>
                <ul>
                    <li data-options="attributes:{'url':'enterprise_lock_manage'}">未通过审批企业管理</li>
                    <li data-options="attributes:{'url':'enterprise_manage'}">已通过审批企业管理</li>
                    <li data-options="attributes:{'url':'member_manage'}">会员管理</li>
                </ul>
            </li>
            <li>
                <span>站点相关管理</span>
                <ul>
                    <li data-options="attributes:{'url':'news_manage'}">新闻管理</li>
                    <li data-options="attributes:{'url':'interviewskill_manage'}">面试技巧管理</li>
                    <li data-options="attributes:{'url':'leavemessage_manage'}">岗位留言管理</li>
                </ul>
            </li>
        <li>
            <span>系统相关管理</span>
            <ul>
                <li data-options="attributes:{'url':'category_manage'}">岗位类别管理</li>
                <li data-options="attributes:{'url':'mail_manage'}">站内邮箱管理</li>
            </ul>
        </li>
        </shiro:hasRole>
        <li>
            <span>个人信息管理</span>
            <ul>
                <%--<li data-options="attributes:{'url':'personalInfo'}">个人信息</li>--%>
                <li data-options="attributes:{'url':'personalPass'}">密码修改</li>
            </ul>
        </li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    if ($('#tt').tabs('exists', node.text)){
                        $('#tt').tabs('select', node.text);
                    } else {
                        var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.attributes.url+'" style="width:100%;height:100%;"></iframe>';
                        $('#tt').tabs('add',{
                            title:node.text,
                            content:content,
                            closable:true
                        });
                    }
                }
            }
        });
    });
</script>
</body>
