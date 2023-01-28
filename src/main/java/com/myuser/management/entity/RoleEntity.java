package com.myuser.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column
    String role;
    @JsonIgnoreProperties("roleEntitySet")
    @ManyToOne
    @JoinColumn(name="username")
    private UserEntity user;
}
