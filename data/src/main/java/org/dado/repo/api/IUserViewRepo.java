package org.dado.repo.api;

import org.dado.entity.ViewUser;

import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public interface IUserViewRepo {
    public void createUser(ViewUser user);
    List<ViewUser> getAll();
}
