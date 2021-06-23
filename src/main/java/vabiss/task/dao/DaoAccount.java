package vabiss.task.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Component;
import vabiss.task.entities.Account;
import vabiss.task.enums.EnumExceptionsMessage;
import vabiss.task.exceptions.EmptyException;
import vabiss.task.exceptions.WrongMailFormatException;
import vabiss.task.exceptions.WrongPasswordException;
import vabiss.task.model.RequestLoginOrRegistry;
import vabiss.task.model.Response;
import vabiss.task.repos.RepoAccount;
import vabiss.task.services.AccountDetailsService;
import vabiss.task.utils.EncryptUtils;
import vabiss.task.utils.JwtUtil;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class DaoAccount {

    @Autowired
    EncryptUtils encryptUtils;

    @Autowired
    AccountDetailsService accountDetailsService;

    @Autowired
    RepoAccount repoAccount;

    @Autowired
    JwtUtil jwtUtil;

    public Response register(RequestLoginOrRegistry requestLoginOrRegistry) {
        if (requestLoginOrRegistry.getUsername().length() != 0
                && requestLoginOrRegistry.getPassword().length() != 0) {
            Optional<Account> account = repoAccount.findAllByUsername(requestLoginOrRegistry.getUsername());
            if (!account.isPresent()) {
                boolean isValid = emailValidator(requestLoginOrRegistry.getUsername());
                if (!isValid) {
                    throw new WrongMailFormatException(EnumExceptionsMessage.WRONG_MAIL_FORMAT.getMessage());
                }
                repoAccount.save(
                        new Account()
                                .setUsername(requestLoginOrRegistry.getUsername())
                                .setPassword(encryptUtils.encrypt(requestLoginOrRegistry.getPassword()))
                                .setDeleted(false)
                                .setCreatedDate(LocalDateTime.now())
                );
                return new Response();
            } else {
                throw new WrongPasswordException(EnumExceptionsMessage.DATA_ALREADY_EXIST.getMessage());
            }
        } else {
            throw new EmptyException(EnumExceptionsMessage.USERNAME_OR_PASSWORD_EMPTY.getMessage());
        }
    }

    private boolean emailValidator(String email) {
        boolean isValid = false;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            isValid = true;
        } catch (AddressException e) {
            System.out.println("You are in catch block -- Exception Occurred for: " + email);
        }
        return isValid;
    }

}
