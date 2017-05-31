package org.dado.repo.api;

import io.realm.RealmResults;
import org.dado.entity.DomainUserRealm;
import org.dado.model.DomainUser;

/**
 * Created by dado on 31.05.17.
 */
public interface IUserRealmRepo {
    RealmResults<DomainUserRealm> getAllUserRealms();
    void createUserRealm(DomainUser domainUser);
}
