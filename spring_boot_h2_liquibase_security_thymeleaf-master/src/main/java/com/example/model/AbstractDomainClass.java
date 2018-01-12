package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractDomainClass implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private LocalDateTime dateCreated;
    private LocalDateTime dateLastUpdated;


    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(LocalDateTime dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        dateLastUpdated = LocalDateTime.now();
        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }
    }
}
