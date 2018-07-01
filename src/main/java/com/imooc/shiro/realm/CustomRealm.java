package com.imooc.shiro.realm;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.imooc.mapper.UserMapper;
import com.imooc.vo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CustomRealm extends AuthorizingRealm{
    @Autowired
    private UserMapper userMapper;


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = getRolesByUserName(userName);
        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);//设置角色
        simpleAuthorizationInfo.setStringPermissions(permissions);//设置权限
        return simpleAuthorizationInfo;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = getPasswordByUserName(userName);
        if(password == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,"customRealm");
        //加盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return authenticationInfo;
    }

    /**
     * 模拟数据
     */
    //模拟数据库
    private String getPasswordByUserName(String userName) {
//        Map<String,String> userMap = new HashMap<>(16);
//        {
//            userMap.put("Mark","283538989cef48f3d7d8a1c1bdf2008f");
//            userMap.put("Mark1","e10adc3949ba59abbe56e057f20f883e");
//            super.setName("customRealm");
//        }
//        return userMap.get(userName);
        List<User> userList = userMapper.selectList(new EntityWrapper<User>().eq("username",userName));
        User user = userList.get(0);
        return user.getPassword();
    }
    //模拟数据库
    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> sets = new HashSet<>();
        sets.add("delete");
        sets.add("update");
        return sets;
    }

    //模拟数据库
    private Set<String> getRolesByUserName(String userName) {
        Set<String> sets = new HashSet<>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }

}
