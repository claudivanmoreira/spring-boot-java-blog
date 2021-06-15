package br.edu.claudivan.springconectado.domain;

import br.edu.claudivan.springconectado.commons.ext.ulid.ULID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "ulid-generator")
    @GenericGenerator(
            name = "ulid-generator",
            strategy = "br.edu.claudivan.springconectado.commons.ext.ulid.ULIDGenerator"
    )
    @Column(name = "id", unique = true, updatable = false)
    protected ULID id;

    @CreationTimestamp
    @Column(name = "created_at")
    protected LocalDateTime createdA;

    @UpdateTimestamp
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    public ULID getId() {
        return id;
    }

    public LocalDateTime getCreatedA() {
        return createdA;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}