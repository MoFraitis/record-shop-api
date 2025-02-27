package com.northcoders.record_shop_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop_api.model.Album;
import com.northcoders.record_shop_api.model.Genre;
import com.northcoders.record_shop_api.service.AlbumServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
class AlbumControllerTest {

    @Mock
    private AlbumServiceImpl mockAlbumService;

    @InjectMocks
    private AlbumController albumController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(albumController).build();
        mapper = new ObjectMapper();
    }

    @Test
    void testGetAllAlbumsReturnsAlbums() throws Exception {

        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1L, "Album1", "Artist1", 2018L, Genre.HIP_HOP, 15));
        albums.add(new Album(2L, "Album2", "Artist2", 2020L, Genre.POP, 10));
//        Album album1 = Album.builder()
//                .id(1L)
//                .albumName("Album1")
//                .artistName("Artist1")
//                .releaseYear(2020L)
//                .genre(Genre.HIP_HOP)
//                .quantityInStock(15)
//                .build();

//        albums.add(album1);

        when(mockAlbumService.getAllAlbums()).thenReturn(albums);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/album"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((MockMvcResultMatchers.jsonPath("$[0].id").value(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumName").value("Album1"))
                .andExpect((MockMvcResultMatchers.jsonPath("$[1].id").value(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].albumName").value("Album2"));
    }

    @Test
    @DisplayName("Returns an Album when passed an existing album id")
    void testGetAlbumByIdValidId() throws Exception {

        Album album = new Album(1L, "Album1", "Artist1", 2018L, Genre.HIP_HOP, 15);

        when(mockAlbumService.getAlbumById(1L)).thenReturn(album);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/album/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((MockMvcResultMatchers.jsonPath("$.id").value(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Album1"));
    }

//    @Test
//    @DisplayName("Returns - when passed an invalid album id")
//    void testGetAlbumByIdInvalidId() throws Exception {
//
//        Album album = new Album(1L, "Album1", "Artist1", 2018L, Genre.HIP_HOP, 15);
//
////        when(mockAlbumService.getAlbumById(3L)).thenReturn();
//
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/api/v1/album/3"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }


    @Test
    void testPostNewAlbumAddAlbum() throws Exception {

        Album album = new Album(1L, "Album1", "Artist1", 2018L, Genre.HIP_HOP, 15);

        when(mockAlbumService.postNewAlbum(album)).thenReturn(album);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/album")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

//        verify(mockAlbumService, times(1)).postNewAlbum(album);
    }

}