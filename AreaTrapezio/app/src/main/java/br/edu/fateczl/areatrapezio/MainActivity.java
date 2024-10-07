package br.edu.fateczl.areatrapezio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {
    private EditText etBaseMaior, etBaseMenor, etAltura;
    private Button btCalc;

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvArea);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }
    private void calc(){
        double bMaior = Double.parseDouble(etBaseMaior.getText().toString());
        double bMenor = Double.parseDouble(etBaseMenor.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());

        double area = (bMaior + bMenor) * altura / 2;
        String resultado = getString(R.string.resultado)+" "+area;
        tvResultado.setText(resultado);

    }
}