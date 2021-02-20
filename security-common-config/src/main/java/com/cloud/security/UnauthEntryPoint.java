package com.cloud.security;

import com.cloud.utils.utils.R;
import com.cloud.utils.utils.ResponseUtil;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SpringCloud2021
 * @description: 未授权统一处理
 * @author: Gan
 * @date: 2021-02-19 12:26
 **/
public class UnauthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.out(httpServletResponse, R.error());
    }
}
