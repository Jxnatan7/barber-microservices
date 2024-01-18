package com.barber.companyservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "company", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cnpj;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BusinessUnit> businessUnits;
}
