package com.northcoders.record_shop_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

//import java.time.LocalDate;


//@Getter
@Entity
//@Table
//@Getter
//@Setter
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Album {

    @Column(updatable = false, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String albumName;

    @Column
    String artistName;

    @Column
//    @JsonFormat(pattern = "yyyy")
//    LocalDate releaseYear;
    Long releaseYear;

    @Column
    @Enumerated(EnumType.ORDINAL)
    Genre genre;

    @Column
    Integer quantityInStock;

    public Album(Long id, String albumName, String artistName, Long releaseYear, Genre genre, Integer quantityInStock) {
        this.id = id;
        this.albumName = albumName;
        this.artistName = artistName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.quantityInStock = quantityInStock;
    }

    public Album() {
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
