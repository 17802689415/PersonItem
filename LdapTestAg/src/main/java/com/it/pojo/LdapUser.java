package com.it.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.naming.Name;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entry(objectClasses = {"inetOrgPerson"},base = "DC=corp,DC=JABIL,DC=org")
public class LdapUser implements UserDetails {
    @Id
    @JSONField
    private Name dn;
    @Attribute(name="employId")
    private String employId;
    @Attribute(name="userPrincipalName")
    private String userPrincipalName;
    @Attribute(name="title")
    private String title;
    @Attribute(name="cn")
    private String cn;

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }
    private List<String> permissions;
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities!=null){
            return authorities;
        }
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "LdapUser{" +
                "employId='" + employId + '\'' +
                ", userPrincipalName='" + userPrincipalName + '\'' +
                ", title='" + title + '\'' +
                ", cn='" + cn + '\'' +
                ", permissions=" + permissions +
                ", authorities=" + authorities +
                '}';
    }
}
