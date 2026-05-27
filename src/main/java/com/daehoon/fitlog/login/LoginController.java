package com.daehoon.fitlog.login;

import com.daehoon.fitlog.login.domain.LoginForm;
import com.daehoon.fitlog.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, Model model) {
        System.out.println("loginForm.getLoginId() = " + loginForm.getLoginId());
        System.out.println("loginForm.getPassword() = " + loginForm.getPassword());
        log.info("loginForm = {}", loginForm);

        return "redirect:/";
    }

}
