package com.teyyub.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(
            name = "fraud_check_history_id_sequence",
            sequenceName = "fraud_check_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_check_history_id_sequence"
    )
    private Long id;

    private long customerId;

    private boolean isFraudster;

    private LocalDateTime createdAt;
}
