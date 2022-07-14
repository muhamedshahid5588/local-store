package com.example.requestsqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

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

        final TextInputEditText ids=(TextInputEditText) findViewById(R.id.id);
        final TextInputEditText subjectmark=(TextInputEditText) findViewById(R.id.subjectname);
        final TextInputEditText maxmark=(TextInputEditText) findViewById(R.id.maxmark);
        Button btnstore=(Button) findViewById(R.id.btnstore);
     //   Button btnview=(Button) findViewById(R.id.btnview);

        btnstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Subject subject=new Subject(
                        ids.getText().toString(),
                        subjectmark.getText().toString(),
                        maxmark.getText().toString());

                DBHelper dbHelper=new DBHelper(MainActivity.this);
                dbHelper.Add(subjectmark.getText().toString().trim(),
                        maxmark.getText().toString().trim());




                sendNetworkRequest(subject);
            }



        });





    }






    private void sendNetworkRequest(Subject subject) {

        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://apps.mnets.in:85/MCTest/Android/CommanAjaxRequest.aspx/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();

        SubjectClient subjectClient=retrofit.create(SubjectClient.class);
        Call<Subject> call=subjectClient.createSubject(subject);

        call.enqueue(new Callback<Subject>() {
            @Override
            public void onResponse(Call<Subject> call, Response<Subject> response) {
                Toast.makeText(MainActivity.this, "Yeah"+response.body().getID(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Subject> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}