package com.daehoon.fitlog;

import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            // 로그인 안되어져있는거니, 기본홈으로 보냄
            return "home";
        }

        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        if (loginMember == null) {
            // 로그인 안되어져있는거니, 기본홈으로 보냄
            return "home";
        }

        // 정상로직
        model.addAttribute("loginMember", loginMember);
        return "loginHome";

    }
}
