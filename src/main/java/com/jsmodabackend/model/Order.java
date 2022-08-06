package com.jsmodabackend.model;

import com.jsmodabackend.enums.Status;
import com.jsmodabackend.model.base.AuditMetadata;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_")
@EntityListeners(AuditingEntityListener.class)
public class Order extends AuditMetadata {

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private Double profit;

    @Column(nullable = false)
    private Status status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> itens;
}
