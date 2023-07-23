package es.travelworld.travelingv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainLogin extends AppCompatActivity {

    private Button btnNewCount;
    private Button btnNewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        btnNewCount=(Button)findViewById(R.id.ButtonAcount);
        btnNewPass=(Button)findViewById(R.id.ButtonForgot);
        setListeners();
    }

    private void setListeners() {

        btnNewCount.setOnClickListener(v -> {
            Intent intent= new Intent(MainLogin.this, MainRegistro.class);
            startActivity(intent);
        });
        btnNewPass.setOnClickListener(v ->{
            Snackbar.make(v, R.string.tarde, Snackbar.LENGTH_LONG).show();
        });
    }
}