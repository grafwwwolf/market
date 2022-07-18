package ru.pigarev.market.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_privilege")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}
