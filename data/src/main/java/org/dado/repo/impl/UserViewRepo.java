package org.dado.repo.impl;

import org.dado.entity.ViewUser;
import org.dado.entity.mapper.UserRealmDataMapper;
import org.dado.model.DomainUser;
import org.dado.repo.api.IUserRealmRepo;
import org.dado.repo.api.IUserViewRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public class UserViewRepo implements IUserViewRepo {
    private IUserRealmRepo mRealmRepo;
    private UserRealmDataMapper mUserRealmDataMapper;

    public UserViewRepo() {
        mRealmRepo = new UserRealmRepo();
        mUserRealmDataMapper = new UserRealmDataMapper();
    }

    @Override
    public void createUser(ViewUser user) {
        mRealmRepo.createUserRealm(new DomainUser(user.getId(), user.getName()));
    }

    @Override
    public List<ViewUser> getAll() {
        List<DomainUser> domainUsers = mUserRealmDataMapper.transform(mRealmRepo.getAllUserRealms());
        List<ViewUser> viewUsers = new ArrayList<>();
        for(DomainUser d : domainUsers)viewUsers.add(new ViewUser(d.getId(), d.getName()));
        return viewUsers;
    }
}
