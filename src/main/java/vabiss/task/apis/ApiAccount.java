package vabiss.task.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vabiss.task.dao.DaoAccount;
import vabiss.task.model.RequestLoginOrRegistry;
import vabiss.task.model.Response;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/api/account")
public class ApiAccount {

    @Autowired
    DaoAccount daoAccount;

    @PostMapping(value = "/registry", produces = "application/json")
    public Response registry(@RequestBody @Valid @NotNull RequestLoginOrRegistry requestRegistry) {
        return daoAccount.register(requestRegistry);
    }
}

