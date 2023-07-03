package com.carmarketanalysis.carmarketanalysis.domain.entities;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.net.URL;
import java.time.LocalDateTime;

@Table("cars")
public class Car {
    @Id
    private final  Long id;

    @Column(value = "name")
    private final Name name;

    @Column(value = "url")
    private final URL url;

    @CreatedDate
    @Column("created_at")
    private final LocalDateTime createdAt;

    public Car(Name name, URL url) {
        this(null, name, url, LocalDateTime.now());
    }

    @PersistenceCreator
    public Car(Long id, Name name, URL url, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
