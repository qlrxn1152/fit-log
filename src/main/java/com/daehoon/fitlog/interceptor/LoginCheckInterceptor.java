package com.daehoon.fitlog.interceptor;

import com.daehoon.fitlog.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        log.info("[LoginCheckInterceptor] requestURI = [{}]" + requestURI);

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            log.info("[LoginCheckInterceptor] 미인증 사용자 요청. requestURI = [{}]", requestURI);

            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false; // 진행멈춤
        }

        return true; // 계속진행 => Controller ...

    }
}
