package vabiss.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vabiss.task.entities.Account;
import vabiss.task.enums.EnumExceptionsMessage;
import vabiss.task.exceptions.NotFoundException;
import vabiss.task.repos.RepoAccount;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    RepoAccount repoAccount;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = repoAccount.findAllByUsername(username);
        if (account.isPresent()) {
            return account.map(users -> new User(users.getUsername(), users.getPassword(), new ArrayList<>())).orElse(null);
        } else {
            throw new NotFoundException(EnumExceptionsMessage.DATA_NOT_FOUND.getMessage());
        }
    }

    public Account localSelectUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account account = localSelectByUsername(userDetails.getUsername());
        if (account != null) {
            return account;
        } else {
            return null;
        }
    }

    public Account localSelectByUsername(String username) {
        return repoAccount.findAllByUsername(username).orElseThrow(null);
    }

}
