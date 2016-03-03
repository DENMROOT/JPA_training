package edu.jpa.blog.domain;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@MappedSuperclass
public abstract class DomainObject {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainObject that = (DomainObject) o;
        return com.google.common.base.Objects.equal(id, that.id) &&
                com.google.common.base.Objects.equal(version, that.version);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(id, version);
    }
}
