package org.dado.repo.impl;

import io.realm.Realm;
import io.realm.RealmResults;
import org.dado.entity.DomainUserRealm;
import org.dado.model.DomainUser;
import org.dado.repo.api.IUserRealmRepo;

/**
 * Created by dado on 31.05.17.
 */
public class UserRealmRepo implements IUserRealmRepo{

    Realm mRealm;

    public UserRealmRepo() {
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public RealmResults<DomainUserRealm> getAllUserRealms() {
        RealmResults<DomainUserRealm> domainUserRealms;
        mRealm.beginTransaction();
        domainUserRealms = mRealm.where(DomainUserRealm.class).findAll();
        mRealm.commitTransaction();
        return domainUserRealms;
    }

    @Override
    public void createUserRealm(DomainUser domainUser) {
        mRealm.beginTransaction();
        DomainUserRealm userRealm = mRealm.createObject(DomainUserRealm.class);
        userRealm.setId(domainUser.getId());
        userRealm.setName(domainUser.getName());
        mRealm.copyToRealm(userRealm);
        mRealm.commitTransaction();
    }
}
