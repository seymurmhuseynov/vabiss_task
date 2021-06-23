package vabiss.task.repos;

import org.springframework.data.repository.CrudRepository;
import vabiss.task.entities.Account;

import java.util.Optional;

public interface RepoAccount extends CrudRepository<Account, Long> {
    Optional<Account> findAllByUsername(String username);
}
