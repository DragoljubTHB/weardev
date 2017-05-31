package org.dado.repo.api;

import org.dado.model.DomainUser;

import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public interface IUserRepo {
    public List<DomainUser> getAllUsers();
    public void createUser(DomainUser user);
}
