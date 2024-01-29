package com.tickettrek.module;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration")
    private int duration;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "director")
    private String director;

    @Column(name = "cast")
    private String cast;

    @Column(name = "genre")
    private String genre;

    @Column(name = "production_company")
    private String productionCompany;

    @Column(name = "production_country")
    private String productionCountry;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "format")
    private String format;

    @Column(name = "language")
    private String language;

    @Column(name = "poster_image")
    private String posterImage;

    @Column(name = "trailer_link")
    private String trailerLink;

    @JsonBackReference
    @OneToMany(mappedBy = "movie")
    private List<ShowTime> showTime;
}
