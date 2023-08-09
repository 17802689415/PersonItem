package com.it.utils.ldap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.util.Date;


@Data
public class LdapUser {

    /**
     * 登录账号
     */
    @Attribute(name = "sAMAccountName")
//    @ApiModelProperty(value = "登录账号", required = true, name = "loginName")
    private String loginName;

    /**
     * 正式名称，即用户姓
     */
    @Attribute(name = "cn")
//    @ApiModelProperty(value = "正式名称，AD域属性值cn，需唯一，例如用工号", name = "userName")
    private String userName;


    /**
     * 显示名称
     */
    @Attribute(name = "displayName ")
//    @ApiModelProperty(value = "显示名称", required = true, name = "displayName")
    private String displayName;

    /**
     * 邮箱
     */
    @Attribute(name = "mail")
//    @ApiModelProperty(value = "邮箱", required = true, name = "email")
    private String email;


}
