package edu.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 14.02.15
 */
@Entity
public class Company {
    @Id @GeneratedValue
    private int id;
    private String name;

    @Version
    private long version;

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
