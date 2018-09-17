package br.com.ads6.reforestcontrol.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.ads6.reforestcontrol.R;
import br.com.ads6.reforestcontrol.helper.ReflorestamentoDAO;
import br.com.ads6.reforestcontrol.model.Reflorestamento;

public class CadastrarReflorestamentoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerEstados;
    Spinner spinnerAno;
    Button botaoCadastrar;

    TextInputEditText campoNumArvoresCortadas;
    TextInputEditText campoVolume;

    int QtdArvoresaSeremRepostas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_reflorestamento);

        //Campos
        campoNumArvoresCortadas = findViewById(R.id.qtdArvoresCortadas_cadastro);
        campoVolume = findViewById(R.id.volume_cadastro);


        //Configuração do SPINNER
        spinnerEstados = findViewById(R.id.spinner_estados);
        ArrayAdapter<CharSequence> adapterEstados = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_spinner_item);
        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstados.setAdapter(adapterEstados);
        spinnerEstados.setOnItemSelectedListener(this);

        spinnerAno = findViewById(R.id.spinner_ano);
        ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(this, R.array.anos, android.R.layout.simple_spinner_item);
        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAno.setAdapter(adapterAno);
        spinnerAno.setOnItemSelectedListener(this);

        // Connfigurando o botão cadastrar
        botaoCadastrar = findViewById(R.id.botao_cadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String anoSelecionado = spinnerAno.getSelectedItem().toString();
                String estadoSelecionado = spinnerEstados.getSelectedItem().toString();
                int qtdArvoresCortadasSelecionada = Integer.parseInt(campoNumArvoresCortadas.getText().toString());
                double volumeSelecionado = Double.parseDouble(campoVolume.getText().toString());

                double valorAserPago;
                int qtdArvoresaSeremRepostas;

                valorAserPago = volumeSelecionado * 0.75;
                qtdArvoresaSeremRepostas = (int) (volumeSelecionado * 6);

                Reflorestamento reflorestamento = new Reflorestamento();
                reflorestamento.setAno(anoSelecionado);
                reflorestamento.setEstado(estadoSelecionado);
                reflorestamento.setNumeroArvoreCortadas(qtdArvoresCortadasSelecionada);
                reflorestamento.setVolumeM3(volumeSelecionado);
                reflorestamento.setValoraSerPago(valorAserPago);
                reflorestamento.setQtdArvoresaSeremRepostas(qtdArvoresaSeremRepostas);

                ReflorestamentoDAO reflorestamentoDAO = new ReflorestamentoDAO(getApplicationContext());
                reflorestamentoDAO.cadastrar(reflorestamento);

                Toast.makeText(CadastrarReflorestamentoActivity.this, "Cadastro realizado com sucesso!!", Toast.LENGTH_SHORT).show();
                //Toast.makeText(CadastrarReflorestamentoActivity.this, ""+anoSelecionado, Toast.LENGTH_SHORT).show();
                //Toast.makeText(CadastrarReflorestamentoActivity.this, ""+estadoSelecionado, Toast.LENGTH_SHORT).show();
                //Toast.makeText(CadastrarReflorestamentoActivity.this, ""+qtdArvoresCortadasSelecionada, Toast.LENGTH_SHORT).show();
                //Toast.makeText(CadastrarReflorestamentoActivity.this, ""+volumeSelecionado, Toast.LENGTH_SHORT).show();
               // Toast.makeText(CadastrarReflorestamentoActivity.this, ""+valorAserPago, Toast.LENGTH_SHORT).show();
               // Toast.makeText(CadastrarReflorestamentoActivity.this, ""+qtdArvoresaSeremRepostas, Toast.LENGTH_SHORT).show();
                //finish();

            }
        });


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(this, "Por favor escolha um estado!", Toast.LENGTH_SHORT).show();

    }

}
