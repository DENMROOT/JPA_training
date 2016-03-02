package edu.jpa.entity;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
@Entity
@Table(name="T_COMPANY")
@SecondaryTable(name="T_COMPANY_DETAILS")
@PrimaryKeyJoinColumn(name="COMPANY_ID", referencedColumnName = "COMPANY_ID")
public class Company {
    @Id
    @Column(name="COMPANY_ID", table = "T_COMPANY")
    private int id;

    @Column(name="COMPANY_NAME",table = "T_COMPANY")
    private String name;

    @Column(name="COMPANY_ADDRESS", table = "T_COMPANY_DETAILS")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
