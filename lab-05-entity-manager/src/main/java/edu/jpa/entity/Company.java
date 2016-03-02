package edu.jpa.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "company")
    private List<Department> departments;


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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
