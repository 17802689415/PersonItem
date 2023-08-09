package com.it.config;

import com.it.utils.ldap.CustomSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

@Configuration
public class LdapConfig {
    private LdapTemplate ldapTemplate;


    private String ldapUrl="LDAPS://corp.JABIL.ORG";

    private String ldapBaseDc="dc=corp,dc=JABIL,dc=org";


    private String ldapUsername="jabil\\3554536";


    private String ldapPasswd="010803zl.@1234567";

//    @Bean
//    public LdapContextSource contextSource() {
//        LdapContextSource contextSource = new LdapContextSource();
//        Map<String, Object> config = new HashMap();
//        contextSource.setUrl(ldapUrl);
//        contextSource.setBase(ldapBaseDc);
//        contextSource.setUserDn(ldapUsername);
//        contextSource.setPassword(ldapPasswd);
//        //  解决乱码
//        config.put("java.naming.ldap.attributes.binary", "objectGUID");
//
//        contextSource.setPooled(true);
//        contextSource.setBaseEnvironmentProperties(config);
//        return contextSource;
//    }

    @Bean
    public LdapTemplate ldapTemplate() {
        LdapContextSource contextSource = new LdapContextSource();
//        String url = "";
//        if (DataSourceLdapConfig.TRANSPORT_TYPE_CLEAR.equals(config.getTransportType())) {
//            url = "ldap://" + config.getServer() + ":" + config.getPort();
//        } else if (DataSourceLdapConfig.TRANSPORT_TYPE_LDAPS.equals(config.getTransportType())) {
//            url = "ldaps://" + config.getServer() + ":" + config.getPort();
//            // ldaps使用自定义的支持SSL的Context配置
//            contextSource = new SSLLdapContextSource();
//        }
        contextSource.setUserDn(ldapUsername);
        contextSource.setPassword(ldapPasswd);
        contextSource.setUrl(ldapUrl);
        contextSource.setBase(ldapBaseDc);
        contextSource.setAnonymousReadOnly(false);
        contextSource.setPooled(false);
        contextSource.afterPropertiesSet();

        this.ldapTemplate = new LdapTemplate(contextSource);
        this.ldapTemplate.setIgnorePartialResultException(true);
        return ldapTemplate;
    }
}
