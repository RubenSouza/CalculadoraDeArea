package com.example.calcarea;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tituloResultado, resultadoDescricao;
    private EditText alturaRevestimento, larguraRevestimento, alturaParede, larguraParede;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tituloResultado = findViewById(R.id.tituloResultado);
        resultadoDescricao = findViewById(R.id.resultadoDescricao);
        alturaRevestimento = findViewById(R.id.alturaRevestimento);
        larguraRevestimento = findViewById(R.id.larguraRevestimento);
        alturaParede = findViewById(R.id.alturaParede);
        larguraParede = findViewById(R.id.larguraParede);

    }

    public void calculate(View view){

        double calcAlturaRevestimento = Double.parseDouble(alturaRevestimento.getText().toString());
        double calcLarguraRevestimento = Double.parseDouble(larguraRevestimento.getText().toString());
        double calcAlturaParede = Double.parseDouble(alturaParede.getText().toString());
        double calcLarguraParede = Double.parseDouble(larguraParede.getText().toString());

        double areaParede = calcAlturaParede * calcLarguraParede;
        double areaRevestimento = calcAlturaRevestimento * calcLarguraRevestimento / 10000;

        double qtdRevestimento = ((areaParede / areaRevestimento));
        double qtdBonus = Math.round(((qtdRevestimento * 10)/100) + qtdRevestimento);

        tituloResultado.setVisibility(View.VISIBLE);
        resultadoDescricao.setVisibility(View.VISIBLE);

        resultadoDescricao.setText("Seu local tem " + areaParede + "m² e você vai precisar de " + new DecimalFormat().format(qtdBonus) +" placas de revestimento para ocupar toda a área deste local.");
    }
}