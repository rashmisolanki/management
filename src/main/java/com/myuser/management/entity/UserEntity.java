package com.myuser.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @Column
    String username;
    @Column
    String password;
    @Column
    String mailid;
    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<RoleEntity> roleEntitySet;

}
