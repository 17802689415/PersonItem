package com.it.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

/**
 * @program com.example.network.framework.jwt
 * @description 用户权限的拦截器
 * @auther Mr.Xiong
 * @create 2021-08-14 13:44:03
 */
@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request);
        //获取token
        String token = request.getHeader("Authorization");
        System.out.println("1"+token);
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            System.out.println("2"+token);
            return;
        }
        //解析token
        String userid;
        try {
            Claims claims = JwtTokenUtils.parseJWT(token);
            userid = claims.getSubject();
            System.out.println(3+userid);
            System.out.println(myUserDetailsService.getAuthority(userid));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String redisKey = "login:" + userid;
//        JwtUser loginUser = (JwtUser) JSON.parseObject(redisCache.getCacheObject(redisKey),JwtUser.class);
        Object loginUser = redisCache.getCacheObject(redisKey);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        //TODO 获取权限信息封装到Authentication中

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,myUserDetailsService.getAuthority(userid));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
        System.out.println(4+token);
    }

//    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
//        super();
//    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain) throws IOException, ServletException {
//        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
//        System.out.println(tokenHeader);
//        // 如果请求头中没有Authorization信息则直接放行了
//        if (tokenHeader == null) {
//            System.out.println("have not");
//            chain.doFilter(request, response);
//            return;
//        }
//        // 如果请求头中有token，则进行解析，并且设置认证信息
//        try {
//            System.out.println(tokenHeader);
//            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
//
//        } catch (Exception e) {
//            //返回json形式的错误信息
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            String reason = "统一处理，原因：" + e.getMessage();
//            response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
//            response.getWriter().flush();
//        }
//    }
//
//    // 这里从token中获取用户信息并新建一个token
//    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) throws Exception {
//        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
//        boolean expiration = JwtTokenUtils.isExpiration(token);
//        if (expiration) {
//            throw new Exception("token超时了");
//        } else {
//            String username = JwtTokenUtils.getUsername(token);
//            String role = JwtTokenUtils.getUserRole(token);
//            if (username != null) {
//                return new UsernamePasswordAuthenticationToken(username, null,
//                        Collections.singleton(new SimpleGrantedAuthority(role))
//                );
//            }
//        }
//        return null;
//    }
}
