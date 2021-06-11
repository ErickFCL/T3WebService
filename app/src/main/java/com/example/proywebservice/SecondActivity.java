package com.example.proywebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proywebservice.entities.Contacto;
import com.example.proywebservice.services.ContactService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lista);


        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                //.baseUrl("https://upn.lumenes.tk/")
                // .baseUrl("https://webhook.site/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();//instancia retrofic
        ContactService service = retrofit2.create(ContactService.class);//instancia nuestro servicio
        Call<List<Contacto>> contactsCall = service.getAll();//asincrono


        contactsCall.enqueue(new Callback<List<Contacto>>() {//recibe una interface
            // contactsCall.enqueue(new Callback<Void>() {//recibe una interface
            @Override//aqui esperar
            public void onResponse(Call<List<Contacto>> call, Response<List<Contacto>> response) {
                //public void onResponse(Call<Void> call, Response<Void> response) {


            }

            @Override//no espera
            public void onFailure(Call<List<Contacto>> call, Throwable t) {
                //public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }
}