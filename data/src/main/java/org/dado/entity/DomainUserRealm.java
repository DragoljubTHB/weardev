package org.dado.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by dado on 31.05.17.
 */
public class DomainUserRealm extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;

    public DomainUserRealm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
