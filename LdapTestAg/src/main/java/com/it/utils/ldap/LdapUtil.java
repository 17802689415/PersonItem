package com.it.utils.ldap;



import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.security.Security;
import java.util.Collection;
import java.util.Hashtable;

public class LdapUtil extends AbstractLdapAuthenticationProvider {
    @Override
    protected DirContextOperations doAuthentication(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
        return null;
    }

    @Override
    protected Collection<? extends GrantedAuthority> loadUserAuthorities(DirContextOperations dirContextOperations, String s, String s1) {
        return null;
    }
    // 新加这个ContextSource属性
    private ContextSource contextSource;

    public ContextSource getContextSource(){
        return contextSource;
    }

    public void setContextSource(ContextSource contextSource){
        this.contextSource = contextSource;
    }

    public static DirContext ldapConnect(String username, String password) throws NamingException {
        // TODO. add DNS lookup based on domain
        final String ldapUrl = "LDAPS://corp.JABIL.ORG";

        Hashtable<String, Object> env = new Hashtable<>();

        //解决No subject alternative DNS name xxxxx的错误
        Security.setProperty("jdk.tls.disabledAlgorithms", "");
        System.setProperty("com.sun.jndi.ldap.object.disableEndpointIdentification", "true");

        env.put(Context.SECURITY_PROTOCOL, "ssl");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "jabil\\"+username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.PROVIDER_URL, ldapUrl);
        //绕过证书认证，别忘记输入正确的类路径
        env.put("java.naming.ldap.factory.socket", "com.it.utils.ldap.DummySSLSocketFactory");
        return new InitialDirContext(env);
    }

//    private static DirContext ctx = null;
////    private String adminName = ;
////    private String adminPassword = "010803zl.@1234567";
//    private static final String ldapUrl = "LDAPS://corp.JABIL.ORG";
//    public static DirContext ldapConnect(String username,String password) throws NamingException {
//        Hashtable<Object, Object> env = new Hashtable<Object, Object>();
//        //解决No subject alternative DNS name xxxxx的错误
//        Security.setProperty("jdk.tls.disabledAlgorithms", "");
//        System.setProperty("com.sun.jndi.ldap.object.disableEndpointIdentification", "true");
//
//        env.put(Context.SECURITY_PROTOCOL, "ssl");
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        env.put(Context.SECURITY_AUTHENTICATION, "simple");
//        env.put(Context.SECURITY_PRINCIPAL, "jabil\\"+username);
//        env.put(Context.SECURITY_CREDENTIALS, password);
//        env.put(Context.PROVIDER_URL, ldapUrl);
//        //绕过证书认证，别忘记输入正确的类路径
//        env.put("java.naming.ldap.factory.socket", "com.it.utils.ldap.DummySSLSocketFactory");
//        ctx = new InitialDirContext(env);
//        return ctx;
//    }

}
