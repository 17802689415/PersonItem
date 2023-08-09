package com.it.utils.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.support.LdapUtils;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

public class LdapUtil {
    @Autowired
    private LdapTemplate ldapTemplate;

    public boolean validResult(String userName, String password) {
        String ladpResult = getResult(userName);
        boolean authenticate = authenticate(ladpResult, password);
        return authenticate;
    }

    public boolean authenticate(String userDn, String credentials) {
        DirContext ctx = null;
        //我先去目录中取到了它的DN，因为getContext方法中参数userDn必须是一个完整的全路径DN。
        //否则它不知道去哪找这个用户，而且登录的用户也不一定都统一放在一个目录路径下
        try {
            ctx = ldapTemplate.getContextSource().getContext(userDn, credentials);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            LdapUtils.closeContext(ctx);
        }
    }

    //根据账号返回一条完整的dn信息 “uid=zhangsan,ou=xxx（组织）,dc=xxx,dc=xxx”
    private String getResult(String userName) {
        List<String> result = ldapTemplate.search(query().where("cn").is(userName), new AbstractContextMapper<String>() {

            @Override
            protected String doMapFromContext(DirContextOperations ctx) {
                return ctx.getNameInNamespace();
            }
        });

        if (result.size() != 1) {
            throw new RuntimeException("账号不是唯一");
        }
        return result.get(0);
    }
}