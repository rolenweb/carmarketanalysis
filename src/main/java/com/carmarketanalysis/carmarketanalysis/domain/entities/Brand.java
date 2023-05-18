package com.carmarketanalysis.carmarketanalysis.domain.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalDateTime;

@Table("brands")
public class Brand {
    @Id
    private final Long id;

    @Column("name")
    private final String name;

    @CreatedDate
    @Column("created_at")
    private final LocalDateTime createdAt;


    @LastModifiedDate
    @Column("updated_at")
    private final LocalDateTime updatedAt;

    public Brand(String name) {
        this(null, name, LocalDateTime.now(), LocalDateTime.now());
    }

    @PersistenceCreator
    public Brand(Long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
