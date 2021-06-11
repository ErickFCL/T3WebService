package com.example.proywebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proywebservice.entities.Contacto;
import com.example.proywebservice.services.ContactService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnEnviar);
        Button btnListar = findViewById(R.id.btnListar);



        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://run.mocky.io/")
                .baseUrl("https://upn.lumenes.tk/")
                //.baseUrl("https://webhook.site/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();//instancia retrofic

        ContactService service = retrofit.create(ContactService.class);//instancia nuestro servicio


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MAIN_APP","HIce click en el boton");
                EditText edtNombre =findViewById(R.id.tvNombre);
                EditText edtNumero =findViewById(R.id.tvNumero);
                String name = edtNombre.getText().toString();
                String tipo = edtNumero.getText().toString();
                Contacto contacto = new Contacto(name,tipo,"http://pngimg.com/uploads/pokemon/pokemon_PNG9.png");
                Call<Contacto> contactsCall = service.CreatePost(contacto);
                contactsCall.enqueue(new Callback<Contacto>() {//recibe una interface
                    @Override//aqui esperar
                       public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                    //public void onResponse(Call<Void> call, Response<Void> response) {


                    }

                    @Override//no espera
                    public void onFailure(Call<Contacto> call, Throwable t) {
                    //public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);
            }
        });
    }
}