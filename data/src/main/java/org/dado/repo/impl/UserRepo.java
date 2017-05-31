package org.dado.repo.impl;

import io.realm.RealmList;
import org.dado.entity.DomainUserRealm;
import org.dado.entity.mapper.UserRealmDataMapper;
import org.dado.model.DomainUser;
import org.dado.repo.api.IUserRepo;

import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public class UserRepo implements IUserRepo {

    private UserRealmRepo mUserRealmRepo;
    private UserRealmDataMapper mUserRealmDataMapper;

    public UserRepo(UserRealmRepo userRealmRepo) {
        mUserRealmRepo = userRealmRepo;
        mUserRealmDataMapper = new UserRealmDataMapper();
    }

    @Override
    public List<DomainUser> getAllUsers() {
        return mUserRealmDataMapper.transform(mUserRealmRepo.getAllUserRealms());
    }

    @Override
    public void createUser(DomainUser user) {
        mUserRealmRepo.createUserRealm(user);
    }
}
