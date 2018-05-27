package cn.yah.controller;

import cn.yah.po.Recruit;
import cn.yah.po.DataGrid;
import cn.yah.po.Page;
import cn.yah.service.RecruitService;
import cn.yah.service.UserService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping(value = "/recruit",produces = {"application/json;charset=UTF-8"} )
public class RecruitController {

    @Autowired
    RecruitService recruitService;


    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(recruitService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        if (SecurityUtils.getSubject().hasRole("1")) {
            dataGrid.setRows(recruitService.vo(recruitService.list(page)));
            dataGrid.setTotal(recruitService.count());
        } else {
            dataGrid.setRows(recruitService.vo(recruitService.listByEid(page,(Integer) SecurityUtils.getSubject().getPrincipal())));
            dataGrid.setTotal(recruitService.count());
        }

        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Recruit recruit) {
        recruit.setPublishtime(new Date());
        recruit.setEid(Integer.parseInt((String) SecurityUtils.getSubject().getPrincipal()));
        try {
            recruitService.insert(recruit);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Recruit recruit) {
        recruit.setRid(id);
        recruit.setPublishtime(new Date());
        try {
            recruitService.update(recruit);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            recruitService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

}
