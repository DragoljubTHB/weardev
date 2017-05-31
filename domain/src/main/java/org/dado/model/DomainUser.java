package org.dado.model;

/**
 * Created by dado on 31.05.17.
 */
public class DomainUser {
    private Integer mId;
    private String mName;

    public DomainUser() {
    }

    public DomainUser(Integer id, String name) {
        mId = id;
        mName = name;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
