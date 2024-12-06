package com.northcoders.record_shop_api.service;

import com.northcoders.record_shop_api.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();
    Album getAlbumById(Long id);
    Album postNewAlbum();
    Album updateAlbum();
    boolean DeleteAlbum();
    // todo : get albums by query
}
