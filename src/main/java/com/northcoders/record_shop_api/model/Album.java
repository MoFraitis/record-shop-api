package com.northcoders.record_shop_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "album")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String name;

    @Column
    String artistName;

    @Column
//    @JsonFormat(pattern = "yyyy")
//    LocalDate releaseYear;
    Long releaseYear;

    @Column
    Genre genre;

    @Column
    Integer quantityInStock;
}
