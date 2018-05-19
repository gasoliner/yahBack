package cn.yah.controller;

import cn.yah.po.Enterprise;
import cn.yah.po.User;
import cn.yah.service.EnterpriseService;
import cn.yah.service.UserService;
import cn.yah.util.PageUtil;
import cn.yah.util.StringUtil;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"} )
public class LoginController {


    @Autowired
    UserService userService;

    @Autowired
    EnterpriseService enterpriseService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password, HttpSession session){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                name,
                password
        );
        try {
            currentUser.login(token);
            User user = userService.selectByPrimaryKey(Integer.parseInt(name));
            session.setAttribute("user",user);
            return "/";
        }catch (Exception e){
            return "/login";
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public void logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return;
    }

    @RequestMapping("/registry")
    @ResponseBody
    public String registryEnterprise(Enterprise enterprise,String password2, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        User user = new User();
        try {
            if (password2 != null && enterprise.getPassword() != null && password2.equals(enterprise.getPassword())) {
                if (file.getSize() > 0) {
                    enterprise.setImg(PageUtil.uploadAnnex(request, file, "enterprise", enterprise.getName()));
                }
                user.setName(enterprise.getName());
                user.setPassword(enterprise.getPassword());
                user.setRid(2);
                userService.insert(user);
                System.out.println("新增企业用户-" + user.getUid());
                enterprise.setEid(user.getUid());
                enterpriseService.insert(enterprise);
            } else {
                throw new Exception();
            }
            return JSON.toJSONString("注册成功，请等待管理员审核。您的账号为" + user.getUid() + "，请务必牢记！");
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("系统出现错误，请稍后再试");
        }
    }
}
