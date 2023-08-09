package com.it.utils.ldap;

import org.springframework.ldap.core.LdapTemplate;

import java.util.List;

public interface LdapService {
//    /**
//     * 获取所有用户
//     * @return list {@link LdapUser}
//     */
//    Iterable<LdapUser> findAllPersons();
//
//    /**
//     * 获取单个用户
//     * @param attribute 属性
//     * @param value 值
//     * @return {@link LdapUser}
//     */
//    LdapUser findOnePerson(String attribute, String value);

    /**
     * 验证的属性
     * @param attribute 属性
     * @param username 用户名
     * @param password 密码
     * @return {@link LdapUser}
     */
    boolean authenticate(String attribute, String username, String password);
}
