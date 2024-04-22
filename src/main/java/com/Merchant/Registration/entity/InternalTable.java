package com.Merchant.Registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INTERNAL_TABLE")
public class InternalTable {
    @Id
    private String tid;
    @Column(
            name = "BATCH_ID"
    )
    private Long batchId;
    private Long stan;
    private String mid;
    private Long invoiceNo;

}
