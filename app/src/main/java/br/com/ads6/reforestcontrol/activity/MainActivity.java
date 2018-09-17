package br.com.ads6.reforestcontrol.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.ads6.reforestcontrol.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void abrirTelaCadastrar(View view){

        Intent intent = new Intent(MainActivity.this, CadastrarReflorestamentoActivity.class);
        startActivity(intent);

    }

    public void abrirTelaConsultar(View view){

        Intent intent = new Intent(MainActivity.this, ConsultarReflorestamentoActivity.class);
        startActivity(intent);

    }

}
