package cn.yah.controller;

import cn.yah.po.DataGrid;
import cn.yah.po.Page;
import cn.yah.po.Jobfair;
import cn.yah.service.JobfairService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/jobfair",produces = {"application/json;charset=UTF-8"} )
public class JobfairController {

    @Autowired
    JobfairService jobfairService;

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(jobfairService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        if (SecurityUtils.getSubject().hasRole("1")) {
            dataGrid.setRows(jobfairService.vo(jobfairService.list(page)));
            dataGrid.setTotal(jobfairService.count());
        } else {
            dataGrid.setRows(jobfairService.vo(jobfairService.listByEid(page,(Integer) SecurityUtils.getSubject().getPrincipal())));
            dataGrid.setTotal(jobfairService.count());
        }
        return JSON.toJSONString(dataGrid);
    }


    @RequestMapping("/addition")
    @ResponseBody
    public String add(Jobfair jobfair) {
        jobfair.setEid((Integer) SecurityUtils.getSubject().getPrincipal());
        try {
            jobfairService.insert(jobfair);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Jobfair jobfair) {
        jobfair.setJfid(id);
        try {
            jobfairService.update(jobfair);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            jobfairService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

}
