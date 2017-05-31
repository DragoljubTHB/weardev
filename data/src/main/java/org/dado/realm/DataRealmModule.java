package org.dado.realm;

import io.realm.annotations.RealmModule;
import org.dado.entity.DomainUserRealm;
import org.dado.entity.EspressoRealm;

/**
 * Created by dado on 31.05.17.
 */
@RealmModule(classes = {DomainUserRealm.class, EspressoRealm.class})
public class DataRealmModule {
}
