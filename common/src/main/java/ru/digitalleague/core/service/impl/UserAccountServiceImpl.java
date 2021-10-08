package ru.digitalleague.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.mapper.AuthorityEntityMapper;
import ru.digitalleague.core.mapper.UserAccountEntityMapper;
import ru.digitalleague.core.model.AuthorityEntity;
import ru.digitalleague.core.model.UserAccountEntity;
import ru.digitalleague.core.service.UserAccountService;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService, UserDetailsService {

    private final UserAccountEntityMapper userAccountEntityMapper;

    private final AuthorityEntityMapper authorityEntityMapper;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountServiceImpl(UserAccountEntityMapper userAccountEntityMapper, AuthorityEntityMapper authorityEntityMapper, PasswordEncoder passwordEncoder) {
        this.userAccountEntityMapper = userAccountEntityMapper;
        this.authorityEntityMapper = authorityEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountEntity accountEntity = userAccountEntityMapper.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Ooops..."));
        return accountEntity;
    }

    @Override
    public UserAccountEntity registration(UserAccountEntity userAccountEntity) {
        String password = passwordEncoder.encode(userAccountEntity.getPassword());
        userAccountEntity.setPassword(password);
        userAccountEntityMapper.insert(userAccountEntity);
        List<AuthorityEntity> authorities = userAccountEntity.getAuthorities();
        authorities.forEach(authorityEntity -> authorityEntity.setUserAccountId(userAccountEntity.getId()));
        authorityEntityMapper.insertAll(authorities);
        return userAccountEntity;
    }

    @Override
    public UserAccountEntity test(String login) {
        UserAccountEntity testSqlInjection = userAccountEntityMapper.findTestSqlInjection(login);
        return testSqlInjection;
    }
}
