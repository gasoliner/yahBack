package cn.yah.controller;

import cn.yah.po.DataGrid;
import cn.yah.po.Page;
import cn.yah.po.Enterprise;
import cn.yah.service.EnterpriseService;
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
@RequestMapping(value = "/enterprise",produces = {"application/json;charset=UTF-8"} )
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;


    @RequestMapping("/lock_list")
    @ResponseBody
    public String lockList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(enterpriseService.vo(enterpriseService.lock_list(page)));
        dataGrid.setTotal(enterpriseService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList(Page page){
        return JSON.toJSONString(enterpriseService.list(page));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(enterpriseService.vo(enterpriseService.list(page)));
        dataGrid.setTotal(enterpriseService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Enterprise enterprise, @RequestParam("img_file") CommonsMultipartFile file, HttpServletRequest request) {
        try {
            if (file.getSize() > 0) {
                enterprise.setImg(PageUtil.uploadAnnex(request,file,"enterprise",enterprise.getName()));
            }
            enterpriseService.insert(enterprise);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Enterprise enterprise,@RequestParam("img_file")CommonsMultipartFile file, HttpServletRequest request) {
        enterprise.setEid(id);
        try {
            if (file.getSize() > 0) {
                enterprise.setImg(PageUtil.uploadAnnex(request,file,"enterprise",enterprise.getName()));
            }
            enterpriseService.update(enterprise);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            enterpriseService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/img/{id}")
    public void pic(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        PageUtil.showImg(enterpriseService.selectByPrimaryKey(id).getImg(),response);
    }

    @RequestMapping("/unlock/{id}")
    @ResponseBody
    public String unlock(@PathVariable Integer id) {
        Enterprise enterprise = new Enterprise();
        enterprise.setEid(id);
        enterprise.setIslock(1);
        try {
            enterpriseService.update(enterprise);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/lock/{id}")
    @ResponseBody
    public String lock(@PathVariable Integer id) {
        Enterprise enterprise = new Enterprise();
        enterprise.setEid(id);
        enterprise.setIslock(0);
        try {
            enterpriseService.update(enterprise);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

}
