package com.example.employeefilter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract_types")
public class ContractsTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_types_seq")
    @SequenceGenerator(name = "contract_types_seq", initialValue = 1, sequenceName = "contract_types_seq", allocationSize = 1)
    private Long id;

    private String name;
}
