package com.jsmodabackend.model;

import com.jsmodabackend.enums.Sex;
import com.jsmodabackend.model.base.AuditMetadata;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Category extends AuditMetadata {

    @Column(nullable = false)
    private String description;

    private Sex sex;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
