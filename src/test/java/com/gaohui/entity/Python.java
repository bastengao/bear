package com.gaohui.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Date: 12-10-6
 * Time: 下午5:33
 *
 * @author bastengao
 */
@Entity
public class Python {
    @Id
    private int id;

    private String name;

    @OneToMany
    public Set<Bear> friends;

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

    public Set<Bear> getFriends() {
        return friends;
    }

    public void setFriends(Set<Bear> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Python{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
