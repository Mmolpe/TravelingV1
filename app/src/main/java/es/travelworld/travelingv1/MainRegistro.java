package es.travelworld.travelingv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;

import com.google.android.material.button.MaterialButton;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;

import es.travelworld.travelingv1.databinding.ActivityMainRegistroBinding;

public class MainRegistro extends AppCompatActivity {

    private ActivityMainRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setActivity(MainRegistro.this);
        binding.setUser(new User());
        openCamera();
        openCondiciones();
        setToolBar();
        setDrow();

    }

    private void openCondiciones() {
        binding.ButtonCondiciones.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://developers.google.com/ml-kit/terms"));
            startActivity(intent);

        });
    }

    private void openCamera() {
        binding.ButtonCamera.setOnClickListener(v -> {
       Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
        }
        );
    }

    public void textIntroNombre(String text) {
        if (!text.contains("!") && !text.contains("@")) {
            binding.nombre.setError(null);
        } else {
            binding.nombre.setError("Ups, no creo que sea correcto, revísalo");
        }
    }

    public void textIntroApellido(String textApe) {
        if (!textApe.contains("!") && !textApe.contains("@")) {
            binding.apellido.setError(null);
        } else {
            binding.apellido.setError("Ups, no creo que sea correcto, revísalo");
        }
    }


    private void setToolBar() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(MainRegistro.this, MainLogin.class);
            startActivity(intent);
        });

    }

    private void setDrow() {
        String[] inputs = new String[]{"0-5", "6-12", "12-17", "18-99"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, inputs);
        binding.autoCompleteEdad.setAdapter(adapter);

        binding.autoCompleteEdad.setOnItemClickListener((parent, view, position, id) -> {
            String selectedOption = (String) parent.getItemAtPosition(position);
            validateSelectedOption(selectedOption);
        });
    }

    private void validateSelectedOption(String selectedOption) {
        if (selectedOption.equals("0-5") || selectedOption.equals("6-12") || selectedOption.equals("12-17")) {
            binding.edad.setError("Esta app no es para ti");
        } else {
            binding.edad.setError(null);
        }
    }
}