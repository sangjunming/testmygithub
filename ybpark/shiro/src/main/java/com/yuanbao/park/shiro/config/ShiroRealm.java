package com.yuanbao.park.shiro.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanbao.park.entity.UPermission;
import com.yuanbao.park.entity.URole;
import com.yuanbao.park.entity.UUser;
import com.yuanbao.park.service.UUserService;
import com.yuanbao.park.shiro.VO.UserVO;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UUserService  uUserService;
    
    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + token.toString());
        
        //查出是否有此用户
        UUser hasUser = uUserService.findByName(token.getUsername());
        if (hasUser != null) {
        	UserVO uservo = null;
        	
            List<URole> rlist = uUserService.findURoleByUid(hasUser.getId());//获取用户角色
            List<UPermission> plist = uUserService.findUPermissionByUid(hasUser.getId());//获取用户权限
            List<String> roleStrlist=new ArrayList<String>();////用户的角色集合
            List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合
            for (URole urole : rlist) {
            	roleStrlist.add(urole.getName());
            }
            for (UPermission uPermission : plist) {
            	perminsStrlist.add(uPermission.getName());
			}
            
            uservo = new UserVO(hasUser,roleStrlist,perminsStrlist);
            
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(uservo, uservo.getPassword(), getName());
        }
        
        return null;
    }
    

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        UserVO user = (UserVO) principalCollection.getPrimaryPrincipal();
        //这里可以添加用户的校验和权限信息
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist()); 
            //用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist()); 

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
    
}
