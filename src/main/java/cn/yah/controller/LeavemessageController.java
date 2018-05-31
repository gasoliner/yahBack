package cn.yah.controller;

import cn.yah.po.DataGrid;
import cn.yah.po.Leavemessage;
import cn.yah.po.Page;
import cn.yah.service.LeavemessageService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping(value = "/leavemessage",produces = {"application/json;charset=UTF-8"} )
public class LeavemessageController {


    @Autowired
    LeavemessageService leavemessageService;

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(leavemessageService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(leavemessageService.list(page));
        dataGrid.setTotal(leavemessageService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Leavemessage leavemessage) {
        leavemessage.setPublishtime(new Date());
        try {
            leavemessageService.insert(leavemessage);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Leavemessage leavemessage) {
        leavemessage.setLmid(id);
        leavemessage.setPublishtime(new Date());
        try {
            leavemessageService.update(leavemessage);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            leavemessageService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

}
