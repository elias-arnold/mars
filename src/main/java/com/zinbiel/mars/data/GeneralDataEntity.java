package com.zinbiel.mars.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by elias on 04.09.17.
 */
@MappedSuperclass
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class)
public abstract class GeneralDataEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected UUID id;
    @UpdateTimestamp
    @JsonIgnore
    private Timestamp updated;
    @CreationTimestamp
    @JsonIgnore
    private Timestamp created;

    @Id
    @Column(name = "id")
    @GeneratedValue
    @Type(type = "uuid-char")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version = 0L;

    @Basic
    @UpdateTimestamp
    @Column(name = "updated", nullable = true)
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }


    @Basic
    @CreationTimestamp
    @Column(name = "created", nullable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
