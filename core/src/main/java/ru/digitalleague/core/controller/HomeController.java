package ru.digitalleague.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.core.model.UserAccountEntity;
import ru.digitalleague.core.service.UserAccountService;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HomeController {

    private final UserAccountService userAccountService;

    @Autowired
    public HomeController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("home")
    public UserAccountEntity home(@RequestParam String login) {
        return userAccountService.test(login);
    }

    @GetMapping("auth")
    public String auth(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "auth " + principal.getName();
    }
}
