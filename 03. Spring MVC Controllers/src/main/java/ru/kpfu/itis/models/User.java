package ru.kpfu.itis.models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String login;
    private String passwordHash;
    private String lastName;
    private String firstName;

    private List<Product> bucket;

    private List<Product> favourites;

}
