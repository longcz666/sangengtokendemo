package com.sgct.sangengtokendemo.handler;

import com.alibaba.fastjson.JSON;
import com.sgct.sangengtokendemo.domain.ResponseResult;
import com.sgct.sangengtokendemo.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(),"您的权限不足请联系管理员!");
        String json = JSON.toJSONString(result);
        //自定义认证失败处理器
        WebUtils.renderString(httpServletResponse,json);
    }
}
