package com.daehoon.fitlog.login.controller;

import com.daehoon.fitlog.member.domain.LoginMemberDto;
import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginHtml(Model model) {
        model.addAttribute("loginMemberDto", new LoginMemberDto());
        return "logins/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginMemberDto loginMemberDto, Model model, HttpSession session) {
        // loginMemberDto -> username, password 랑 일치하는게 memberRepository 에 있는지 확인
        String loginUsername = loginMemberDto.getUsername();
        String loginPassword = loginMemberDto.getPassword();

        Member loginMember = memberService.findByUsername(loginUsername);

        if (loginMember == null) {
            return "redirect:/login";
        }
        // 아이디가 같은게 존재 => 패스워드만 맞는지 확인

        boolean isMatch = loginMember.isMatchPassword(loginPassword);
        if (!isMatch) {
            return "redirect:/login";
        }

        log.info("[LOGIN SUCCESS] loginMember = [{}]", loginMember);

        session.setAttribute("loginMember", loginMember); // 세션에 저장해서 내가 로그인한 사람이라는것을 증명 ?
        return "redirect:/";
    }

}
