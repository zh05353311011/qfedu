package com.qfedu;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 10:29
 * description:
 */
public class TestShiro {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager=new DefaultSecurityManager();

        IniRealm iniRealm=new IniRealm("classpath:shiro.ini");

        securityManager.setRealm(iniRealm);
    }

}
