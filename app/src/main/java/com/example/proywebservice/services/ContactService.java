package com.example.proywebservice.services;

import com.example.proywebservice.entities.Contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ContactService {
    //@GET("pokemons/n00020449")//llamas a url para listar
    @GET("pokemons/00020449")//llamas a url para listar
    Call<List<Contacto>> getAll();

    @GET("cb0bc66a-9a33-4d08-99e2-661d0d77b830")
    Call<Void> testGet(@Query("name") String name, @Query("Lastname") String LastName);

    @POST("pokemons/00020449/create")//para crear
    Call<Contacto> CreatePost(@Body Contacto contacto);






}
