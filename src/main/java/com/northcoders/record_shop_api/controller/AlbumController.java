package com.northcoders.record_shop_api.controller;

import com.northcoders.record_shop_api.model.Album;
import com.northcoders.record_shop_api.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(albumService.getAlbumById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumService.postNewAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }
}
