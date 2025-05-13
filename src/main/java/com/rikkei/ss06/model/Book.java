package com.rikkei.ss06.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int quantity;
}
