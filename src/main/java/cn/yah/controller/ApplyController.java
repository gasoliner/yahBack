package cn.yah.controller;

import cn.yah.po.*;
import cn.yah.service.ApplyService;
import cn.yah.service.EnterpriseService;
import cn.yah.service.MailService;
import cn.yah.service.RecruitService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/apply",produces = {"application/json;charset=UTF-8"} )
public class ApplyController {

    @Autowired
    ApplyService applyService;

    @Autowired
    RecruitService recruitService;

    @Autowired
    MailService mailService;

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(applyService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        if (SecurityUtils.getSubject().hasRole("1")) {
            dataGrid.setRows(applyService.vo(applyService.list(page)));
            dataGrid.setTotal(applyService.count());
        } else {
            List<Recruit> list = recruitService.listByEid(page,Integer.parseInt((String) SecurityUtils.getSubject().getPrincipal()));
            List<Apply> list1 = new ArrayList<>();
            for (Recruit recruit:
                    list) {
                list1.addAll(applyService.listByRid(page, recruit.getRid()));
            }
            dataGrid.setRows(applyService.vo(list1));
            dataGrid.setTotal(Long.valueOf(list1.size()));
        }
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Apply Apply) {
        try {
            applyService.insert(Apply);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Apply apply) {
        apply.setAid(id);
        try {
            applyService.update(apply);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            applyService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/refuse/{id}")
    @ResponseBody
    public String refuse(@PathVariable Integer id) {
        String content_refuse = "<h2 style=\"text-align:center;\">\n" +
                "\t&nbsp; &nbsp; 感谢函\n" +
                "</h2>\n" +
                "<p>\n" +
                "\t&nbsp;&nbsp;&nbsp;&nbsp;感谢您参与本次招聘，但我们遗憾的通知您，你不适合这个岗位，但这不会影响您后期与我公司的合作，您的优秀的简历已经加入到我公司的人才库中，后面有招聘我们会第一时间联系您。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t&nbsp; &nbsp; 谢谢。\n" +
                "</p>";
        Apply apply = applyService.selectByPrimaryKey(id);
        Recruit recruit = recruitService.selectByPrimaryKey(apply.getRid());
        apply.setVar("已回绝");
        Mail mail = new Mail();
        mail.setTime(new Date());
        mail.setContent(content_refuse);
        mail.setName("感谢信-" + recruit.getName() + "-岗位拒信");
        mail.setReceiver(apply.getMid());
        mail.setSender(1001);
        try {
            applyService.update(apply);
            mailService.insert(mail);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/pass/{id}")
    @ResponseBody
    public String pass(@PathVariable Integer id) {
        Apply apply = applyService.selectByPrimaryKey(id);
        apply.setVar("已通过");
        try {
            applyService.update(apply);
            return apply.getMid().toString();
        } catch (Exception e) {
            return "failed";
        }
    }

}
