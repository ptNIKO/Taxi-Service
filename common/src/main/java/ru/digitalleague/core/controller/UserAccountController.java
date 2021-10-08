package ru.digitalleague.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.core.model.UserAccountEntity;
import ru.digitalleague.core.service.UserAccountService;

@RestController
public class UserAccountController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/registration")
    public ResponseEntity<UserAccountEntity> registration(
            @RequestBody UserAccountEntity userAccountEntity) {

        UserAccountEntity accountEntity = userAccountService.registration(userAccountEntity);

        return ResponseEntity.ok(accountEntity);
    }
}
