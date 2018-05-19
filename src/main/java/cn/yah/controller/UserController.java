package cn.yah.controller;

import cn.yah.po.*;
import cn.yah.service.UserService;
import cn.yah.service.MailService;
import cn.yah.service.RecruitService;
import cn.yah.util.StringUtil;
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
@RequestMapping(value = "/user",produces = {"application/json;charset=UTF-8"} )
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/password")
    @ResponseBody
    public String password(Integer uid,String oldpassword,String newpassword1,String newpassword2){
        try {
            if (
                    StringUtil.isNotEmpty(oldpassword) &&
                            StringUtil.isNotEmpty(newpassword1) &&
                            StringUtil.isNotEmpty(newpassword2) &&
                            newpassword1.equals(newpassword2)
                    ) {
                User user = userService.selectByPrimaryKey(uid);
                if (user == null) {
                    throw new Exception();
                }
                if (!user.getPassword().equals(oldpassword)) {
                    throw new Exception();
                }
                user.setPassword(newpassword1);
                userService.update(user);
                return JSON.toJSONString("修改成功，下次登录生效");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return JSON.toJSONString("系统出错，请稍后再试");
        }
    }

}
