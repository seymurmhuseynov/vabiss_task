package vabiss.task.repos;

import org.springframework.data.repository.CrudRepository;
import vabiss.task.entities.Account;

public interface RepoAccount extends CrudRepository<Account, Long> {
}
