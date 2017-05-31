package org.dado.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by dado on 31.05.17.
 */
public class EspressoRealm extends RealmObject{
    @PrimaryKey
    private int id;
}
