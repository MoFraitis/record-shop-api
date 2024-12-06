package com.northcoders.record_shop_api.service;

import com.northcoders.record_shop_api.model.Album;
import com.northcoders.record_shop_api.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    @Override
    public Album getAlbumById(Long id) {
//        Optional<Album> album = albumRepository.findById(id);
//        if(album.isPresent()) {
//            return album.get();
//        } else {
//            throw new ItemNotFoundException(String.format("Album with id '%s' cannot be found", id));
//        }
        return null;
    }

    @Override
    public Album postNewAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album updateAlbum() {
        return null;
    }

    @Override
    public boolean DeleteAlbum() {
        return false;
    }
}
