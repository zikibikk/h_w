package ru.kpfu.itis.models;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    private Long id;
    private User user;
    private String cookieValue;

}
