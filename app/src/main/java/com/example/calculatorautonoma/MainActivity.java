package com.example.calculatorautonoma;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculatorautonoma.dao.OperacionesCalculadoraDAO;

public class MainActivity extends AppCompatActivity {

    private EditText texto1, texto2;
    private TextView resultado;
    private OperacionesCalculadoraDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los elementos de la interfaz de usuario
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        resultado = findViewById(R.id.resultado);
        dao = new OperacionesCalculadoraDAO();

        // Asignar listeners a los botones para manejar los eventos de clic
        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnDiv = findViewById(R.id.btnDiv);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("suma");
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("resta");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("multiplicacion");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("division");
            }
        });
    }

    // Método para calcular el resultado y mostrarlo en el TextView
    private void calcularResultado(String operacion) {
        int num1 = Integer.parseInt(texto1.getText().toString());
        int num2 = Integer.parseInt(texto2.getText().toString());
        int resultadoOperacion = 0;

        switch (operacion) {
            case "suma":
                resultadoOperacion = dao.adicion(num1, num2);
                break;
            case "resta":
                resultadoOperacion = dao.substraccion(num1, num2);
                break;
            case "multiplicacion":
                resultadoOperacion = dao.multiplicacion(num1, num2);
                break;
            case "division":
                resultadoOperacion = dao.division(num1, num2);
                break;
        }

        resultado.setText(String.valueOf(resultadoOperacion));
    }
}
