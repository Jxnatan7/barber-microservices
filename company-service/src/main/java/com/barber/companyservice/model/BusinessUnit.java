package com.barber.companyservice.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "business_unit")
public class BusinessUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "zip_code")
    private String zipCode;
    private String street;
    private String district;
    private Integer number;
    private String city;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
