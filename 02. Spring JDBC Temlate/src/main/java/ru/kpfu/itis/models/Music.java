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
public class Music {
    private Long id;
    private String author;
    private String title;
    private String filePath;
    private List<User> musicListeners;
}
