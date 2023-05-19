package com.example.simple_banking_app.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
class UserEntity {

    @Id
    @EqualsAndHashCode.Include
    private String pesel;
    private String name;
    private String surname;
}
