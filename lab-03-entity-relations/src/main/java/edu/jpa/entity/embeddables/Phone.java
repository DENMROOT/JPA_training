package edu.jpa.entity.embeddables;

import javax.persistence.Embeddable;

/**
 * Created by dp-ptcstd-28 on 3/1/2016.
 */
@Embeddable
public class Phone {
    private String phoneNumber;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
