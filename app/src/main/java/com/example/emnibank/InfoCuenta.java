package com.example.emnibank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;


public class InfoCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cuenta);
        new MiAsyncTask().execute();
    }

    private class MiAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            return RESTservice.makeGetRequest(
                    "http://192.168.1.19:8080/EmniApp/rest/cuenta");
        }

        @Override
        protected void onPostExecute(String result) {
            Toast notificacion = Toast.makeText(getApplicationContext(), "hola:"+result,
                    Toast.LENGTH_SHORT);
            notificacion.show();

//            TextView comp = findViewById(R.id.movText);
//            comp.setText(result);
        }
    }
}
