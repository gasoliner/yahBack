package cn.yah.security;

import cn.yah.po.User;
import cn.yah.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class DefineRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

//    授权的验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授予权限");
        String id = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        User user = userService.selectByPrimaryKey(Integer.parseInt(id));
        Set<String> roleSet = new HashSet<>();
        roleSet.add(user.getRid().toString());

        authorizationInfo.setRoles(roleSet);
//        authorizationInfo.setStringPermissions(roleService.getPermissionByRid(Long.parseLong(user.getRoleidsstr())));

//        System.out.println(roleService.getPermissionByRid(Long.parseLong(user.getRoleidsstr())));

        return authorizationInfo;
    }

//    登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录验证中");
        String name = (String) authenticationToken.getPrincipal();
        User user = userService.selectByPrimaryKey(Integer.parseInt(name));
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getName(),
                user.getPassword(),
                getName()
        );
        return authenticationInfo;
    }
}
