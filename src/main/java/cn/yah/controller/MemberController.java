package cn.yah.controller;

import cn.yah.po.DataGrid;
import cn.yah.po.Page;
import cn.yah.po.Member;
import cn.yah.service.MemberService;
import cn.yah.util.PageUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/member",produces = {"application/json;charset=UTF-8"} )
public class MemberController {


    @Autowired
    MemberService memberService;

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(memberService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(memberService.vo(memberService.list(page)));
        dataGrid.setTotal(memberService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Member member, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        try {
            if (file != null && file.getSize() > 0) {
                member.setResume(PageUtil.uploadAnnex(request,file,"resume",member.getName()));
            }
            memberService.insert(member);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Member member, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        member.setMid(id);
        try {
            if (file != null && file.getSize() > 0) {
                member.setResume(PageUtil.uploadAnnex(request,file,"resume",member.getName()));
            }
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            memberService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/resume/{id}")
    @ResponseBody
    public void resumeDownload(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        PageUtil.downloadFile(memberService.selectByPrimaryKey(id).getResume(),response);
        return;
    }

}
