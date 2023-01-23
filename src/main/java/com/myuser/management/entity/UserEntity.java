package com.myuser.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<RoleEntity> roleEntitySet;

}
