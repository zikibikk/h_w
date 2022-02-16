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
    private String firstName;
    private String lastName;
    private String login;
    private String passwordHash;

    private Double wallet;

    private List<Music> favourites;
}
