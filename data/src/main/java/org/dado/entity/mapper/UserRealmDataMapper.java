package org.dado.entity.mapper;

import io.realm.RealmList;
import io.realm.RealmResults;
import org.dado.entity.DomainUserRealm;
import org.dado.model.DomainUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public class UserRealmDataMapper {

    public DomainUser transform(DomainUserRealm domainUserRealm){
        DomainUser domainUser = new DomainUser();
        domainUser.setId(domainUserRealm.getId());
        domainUser.setName(domainUserRealm.getName());
        return domainUser;
    }

        public List<DomainUser> transform(RealmList<DomainUserRealm> domainUserRealms){
        List<DomainUser> domainUsers = new ArrayList<>();
        DomainUser domainUser;
        for(DomainUserRealm userRealm : domainUserRealms){
            domainUser = transform(userRealm);
            domainUsers.add(domainUser);
        }
        return domainUsers;
    }
    public List<DomainUser> transform(RealmResults<DomainUserRealm> domainUserRealms){
        RealmList<DomainUserRealm> realmList = new RealmList<>();
        realmList.addAll(domainUserRealms);
        return transform(realmList);
    }


}
