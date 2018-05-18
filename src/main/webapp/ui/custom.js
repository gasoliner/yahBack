function newRecruit() {
    $("#fm").form("clear");
    $("#RecruitDialog").dialog("open").dialog("setTitle","新建");
    url = "/recruit/addition";
}
function editRecruit() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#RecruitDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/recruit/updates/"+row.rid;
    }
}
function destroyRecruit() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/recruit/deletion/"+row.aid,
                    success: function (res) {
                        alert(res);
                        $("#RecruitDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveRecruit() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#RecruitDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newCategory() {
    $("#fm").form("clear");
    $("#CategoryDialog").dialog("open").dialog("setTitle","新建");
    url = "/category/addition";
}
function editCategory() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#CategoryDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/category/updates/"+row.cid;
    }
}
function destroyCategory() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/category/deletion/"+row.cid,
                    success: function (res) {
                        alert(res);
                        $("#CategoryDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveCategory() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#CategoryDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newEnterprise() {
    $("#fm").form("clear");
    $("#EnterpriseDialog").dialog("open").dialog("setTitle","新建");
    url = "/enterprise/addition";
}
function editEnterprise() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#EnterpriseDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/enterprise/updates/"+row.eid;
    }
}
function destroyEnterprise() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/enterprise/deletion/"+row.eid,
                    success: function (res) {
                        alert(res);
                        $("#EnterpriseDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveEnterprise() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#EnterpriseDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showEnterprise() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showEnterpriseInfoDialog").dialog("open").dialog("setTitle",row.title);
        $("#name_content").html(row.name);
        $("#nature_content").html(row.nature);
        $("#scale_content").html(row.scale);
        $("#website_content").html(row.website);
        $("#trade_content").html(row.trade);
        $("#addr_content").html(row.addr);
        $("#phone_content").html(row.phone);
        $("#email_content").html(row.email);
        $("#img_content").html(row.voImg);
        $("#info_content").html(row.info);
    }
}
function showEnterprisePic(id) {
    $("#showEnterpriseDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/enterprise/img/"+id);

}
function unlockEnterprise(id) {
    $.get("/enterprise/unlock/" + id,null,function (data) {
        alert(data);
        $('#dg').datagrid("reload");
    })
}
function lockEnterprise(id) {
    $.get("/enterprise/lock/" + id,null,function (data) {
        alert(data);
        $('#dg').datagrid("reload");
    })
}

function newJobfair() {
    $("#fm").form("clear");
    $("#JobfairDialog").dialog("open").dialog("setTitle","新建");
    url = "/jobfair/addition";
}
function editJobfair() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#JobfairDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/jobfair/updates/"+row.jfid;
    }
}
function destroyJobfair() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/jobfair/deletion/"+row.jfid,
                    success: function (res) {
                        alert(res);
                        $("#JobfairDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveJobfair() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#JobfairDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showJobfair() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showJobfairDialog").dialog("open").dialog("setTitle",row.title);
        $("#eid_content").html(row.voEid);
        $("#name_content").html(row.name);
        $("#content_content").html(row.content);
    }
}

function newNews() {
    $("#fm").form("clear");
    $("#NewsDialog").dialog("open").dialog("setTitle","新建");
    url = "/news/addition";
}
function editNews() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#NewsDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/news/updates/"+row.nid;
    }
}
function destroyNews() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/news/deletion/"+row.nid,
                    success: function (res) {
                        alert(res);
                        $("#NewsDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveNews() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#NewsDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showNews() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showNewsDialog").dialog("open").dialog("setTitle",row.title);
        $("#name_content").html(row.name);
        $("#content_content").html(row.content);
        $("#publishtime_content").html(row.publishtime);
    }
}


function newMail() {
    $("#fm").form("clear");
    $("#MailDialog").dialog("open").dialog("setTitle","新建");
    url = "/mail/addition";
}
function editMail() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#MailDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/mail/updates/"+row.maid;
    }
}
function destroyMail() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/mail/deletion/"+row.maid,
                    success: function (res) {
                        alert(res);
                        $("#MailDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveMail() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#MailDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showMail() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showMailDialog").dialog("open").dialog("setTitle",row.title);
        $("#name_content").html(row.name);
        $("#voSender_content").html(row.voSender);
        $("#voReceiver_content").html(row.voReceiver);
        $("#content_content").html(row.content);
        $("#time_content").html(row.time);
    }
}

function newInterviewskill() {
    $("#fm").form("clear");
    $("#InterviewskillDialog").dialog("open").dialog("setTitle","新建");
    url = "/interviewskill/addition";
}
function editInterviewskill() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#InterviewskillDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/interviewskill/updates/"+row.iid;
    }
}
function destroyInterviewskill() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/interviewskill/deletion/"+row.iid,
                    success: function (res) {
                        alert(res);
                        $("#InterviewskillDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveInterviewskill() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#InterviewskillDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showInterviewskill() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showInterviewskillDialog").dialog("open").dialog("setTitle",row.title);
        $("#name_content").html(row.name);
        $("#content_content").html(row.content);
        $("#publishtime_content").html(row.publishtime);
    }
}

function newMember() {
    $("#fm").form("clear");
    $("#MemberDialog").dialog("open").dialog("setTitle","新建");
    url = "/member/addition";
}
function editMember() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#MemberDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/member/updates/"+row.mid;
    }
}
function destroyMember() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/member/deletion/"+row.mid,
                    success: function (res) {
                        alert(res);
                        $("#MemberDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveMember() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#MemberDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showMember() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showMemberDialog").dialog("open").dialog("setTitle",row.title);
        $("#mid_content").html(row.mid);
        $("#name_content").html(row.name);
        $("#phone_content").html(row.phone);
        $("#email_content").html(row.email);
        $("#age_content").html(row.age);
        $("#university_content").html(row.university);
        $("#point_content").html(row.point);
        $("#idnumber_content").html(row.idnumber);
        $("#voResume_content").html(row.voResume);
    }
}
function showMemberResume(id) {
    window.open("/member/resume/" + id);
}

function newApply() {
    $("#fm").form("clear");
    $("#ApplyDialog").dialog("open").dialog("setTitle","新建");
    url = "/apply/addition";
}
function editApply() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#ApplyDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/apply/updates/"+row.aid;
    }
}
function destroyApply() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/apply/deletion/"+row.aid,
                    success: function (res) {
                        alert(res);
                        $("#ApplyDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveApply() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#ApplyDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showApplyMember() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showApplyDialog").dialog("open").dialog("setTitle",row.title);
        $("#mid_content").html(row.member.mid);
        $("#name_content").html(row.member.name);
        $("#phone_content").html(row.member.phone);
        $("#email_content").html(row.member.email);
        $("#age_content").html(row.member.age);
        $("#university_content").html(row.member.university);
        $("#point_content").html(row.member.point);
        $("#idnumber_content").html(row.member.idnumber);
        $("#voResume_content").html(row.voResume);
    }
}
function editInterviewOffer(id) {
    $.post("/apply/pass/" + id,null,function (data) {
        if(data != 'failed') {
            $("#receiveId").val(data);
        }
    });
    $("#fm").form("clear");
    $("#MailDialog").dialog("open").dialog("setTitle","新建");
}
function sendPassMail() {
    $.post("/mail/addition",
        {
            name:$("#pass_email_name").val(),
            receiver:$("#receiveId").val(),
            content:$("#pass_email_content").val()
        }
        ,function (data) {
        alert(data);
        $("#MailDialog").dialog("close");
        $('#dg').datagrid("reload");
    });
}
function refuseThisMan(id) {
    $.post("/apply/refuse/" + id, null,function (data) {
        alert(data);
        $('#dg').datagrid("reload");
    });
}





















function newUser() {
    $("#fm").form("clear");
    $("#userDialog").dialog("open").dialog("setTitle","新建");
    url = "/user/add";
}
function editUser() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#userDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/user/update?sid="+row.sid;
    }
}
function destroyUser() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/user/delete?sid="+row.sid,
                    success: function (res) {
                        alert(res);
                        $("#userDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveUser() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#userDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function subNewUser() {
    $.post("/user/add",{
        number:$("#number").val(),
        username:$("#username").val(),
        sex:$("input[name='sex']:checked").val(),
        classs:$("#classs").val(),
        signature:$("#signature").val(),
        email:$("#email").val(),
        phone:$("#phone").val(),
    },function (backresult) {
        alert(backresult);
    })
}

function perInf1() {
    $.post("/manager/updates/" + $("#mid").val(),
        {
            mid:$("#mid").val(),
            name:$("#name").val(),
            username:$("#username").val(),
            sex:$("input[name='sex']:checked").val(),
            phone:$("#phone").val(),
            email:$("#email").val()
        },
        function (data) {
            alert(data);
        });
}
function perPas1() {
    $.post("/manager/password",
        {
            mid:$("#mid").val(),
            oldpassword:$("#oldpass").val(),
            newpassword1:$("#newpass1").val(),
            newpassword2:$("#newpass2").val()
        },
        function (data) {
            alert(data);
        });
}

function showAttractionPic(id) {
    $("#showAttractionDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/attraction/img/"+id);

}

function showHousePic(id) {
    $("#showHouseDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/house/img/"+id);

}

function showHotelPic(id) {
    $("#showHotelDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/hotel/img/"+id);

}

function showSpecialPic(id) {
    $("#showSpecialDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#att_img").attr("src","/special/img/"+id);

}

function newRegion() {
    $("#fm").form("clear");
    $("#RegionDialog").dialog("open").dialog("setTitle","新建");
    url = "/region/addition";
}
function editRegion() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#RegionDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/region/updates/"+row.rid;
    }
}
function destroyRegion() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/region/deletion/"+row.rid,
                    success: function (res) {
                        alert(res);
                        $("#RegionDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveRegion() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#RegionDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newAttraction() {
    $("#fm").form("clear");
    $("#AttractionDialog").dialog("open").dialog("setTitle","新建");
    url = "/attraction/addition";
}
function editAttraction() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#AttractionDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/attraction/updates/"+row.aid;
    }
}
function destroyAttraction() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/attraction/deletion/"+row.aid,
                    success: function (res) {
                        alert(res);
                        $("#AttractionDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveAttraction() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#AttractionDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newRoute() {
    $("#fm").form("clear");
    $("#RouteDialog").dialog("open").dialog("setTitle","新建");
    url = "/route/addition";
}
function editRoute() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#RouteDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/route/updates/"+row.rtid;
    }
}
function destroyRoute() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/route/deletion/"+row.rtid,
                    success: function (res) {
                        alert(res);
                        $("#RouteDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveRoute() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#RouteDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newHotel() {
    $("#fm").form("clear");
    $("#HotelDialog").dialog("open").dialog("setTitle","新建");
    url = "/hotel/addition";
}
function editHotel() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#HotelDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/hotel/updates/"+row.hid;
    }
}
function destroyHotel() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/hotel/deletion/"+row.hid,
                    success: function (res) {
                        alert(res);
                        $("#HotelDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveHotel() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#HotelDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newHouse() {
    $("#fm").form("clear");
    $("#HouseDialog").dialog("open").dialog("setTitle","新建");
    url = "/house/addition";
}
function editHouse() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#HouseDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/house/updates/"+row.hoid;
    }
}
function destroyHouse() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/house/deletion/"+row.hoid,
                    success: function (res) {
                        alert(res);
                        $("#HouseDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveHouse() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#HouseDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newSpecial() {
    $("#fm").form("clear");
    $("#SpecialDialog").dialog("open").dialog("setTitle","新建");
    url = "/special/addition";
}
function editSpecial() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#SpecialDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/special/updates/"+row.sid;
    }
}
function destroySpecial() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/special/deletion/"+row.sid,
                    success: function (res) {
                        alert(res);
                        $("#SpecialDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveSpecial() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#SpecialDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}


function newBook() {
    $("#fm").form("clear");
    $("#BookDialog").dialog("open").dialog("setTitle","新建");
    url = "/book/addition";
}
function editBook() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#BookDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/book/updates/"+row.id;
    }
}
function destroyBook() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/book/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#BookDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveBook() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#BookDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function showBook() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#showBookDialog").dialog("open").dialog("setTitle",row.title);
        $("#bookname_content").html(row.bookname);
        $("#author_content").html(row.author);
        $("#publishyear_content").html(row.publishyear);
        $("#pages_content").html(row.pages);
        $("#price_content").html(row.price);
        $("#score_content").html(row.score);
        $("#content_content").html(row.content);
        $("#author_info_content").html(row.authorinfo);
    }
}

function newFile() {
    $("#fm").form("clear");
    $("#fileDialog").dialog("open").dialog("setTitle","新建");
    url = "/classsFile/add";
}
function editFile() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#fileDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/classsFile/update?cfid="+row.cfid;
    }
}
function destroyFile() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/classsFile/delete?cfid="+row.cfid,
                    success: function (res) {
                        alert(res);
                        $("#fileDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveFile() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#fileDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newAchievement() {
    $("#fm").form("clear");
    $("#achievementDialog").dialog("open").dialog("setTitle","新建");
    url = "/achievement/add";
}
function editAchievement() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#achievementDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/achievement/update?aid="+row.aid;
    }
}
function destroyAchievement() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/achievement/delete?aid="+row.aid,
                    success: function (res) {
                        alert(res);
                        $("#achievementDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveAchievement() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#achievementDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function login() {
    $("#fm").form("submit",{
        url:"/user/signin",
        success:function (res) {
            window.location.href = res;
        }
    })
}
function logout() {
    $.get("/user/signout",null,function (res) {
        window.location.href = "/UI/sign";
    })
}