package com.recipe.recipe.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    private String username;

    @OneToMany(mappedBy = "user")
    private Collection<Recipe> recipes;

}
