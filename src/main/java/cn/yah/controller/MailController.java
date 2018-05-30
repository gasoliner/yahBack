package cn.yah.controller;

import cn.yah.po.DataGrid;
import cn.yah.po.Mail;
import cn.yah.po.Page;
import cn.yah.service.MailService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping(value = "/mail",produces = {"application/json;charset=UTF-8"} )
public class MailController {


    @Autowired
    MailService mailService;

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(mailService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(mailService.vo(mailService.list(page)));
        dataGrid.setTotal(mailService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Mail mail) {
//        mail.set
        mail.setSender(1001);
        mail.setTime(new Date());
        try {
            mailService.insert(mail);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Mail mail) {
        mail.setMaid(id);
        mail.setTime(new Date());
        try {
            mailService.update(mail);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            mailService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

}
