package br.com.ads6.reforestcontrol.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.ads6.reforestcontrol.R;

public class ConsultarReflorestamentoActivity extends AppCompatActivity  {

    private RadioGroup radioGroup;
    private String radioSelecionado;
    private Spinner spinner;
    private Button botaoConsultar;
    private String opcaoSelecionada;
    private String opcaoSelecionada2;
    private RadioButton radioAno;
    private RadioButton radioEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_reflorestamento);

        radioGroup = findViewById(R.id.radioGroup);
        radioAno = findViewById(R.id.radioAno);
        radioEstado = findViewById(R.id.radioEstado);

        spinner = findViewById(R.id.spinner);

        botaoConsultar = findViewById(R.id.botao_consultar);

        ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(getBaseContext(), R.array.anos, android.R.layout.simple_spinner_item);
        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterAno);

        opcaoSelecionada = radioAno.getText().toString();
        opcaoSelecionada2 = spinner.getSelectedItem().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                if (checkedId == R.id.radioAno) {

                    ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(getBaseContext(), R.array.anos, android.R.layout.simple_spinner_item);
                    adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapterAno);

                    opcaoSelecionada = radioAno.getText().toString();
                    opcaoSelecionada2 = spinner.getSelectedItem().toString();

                } else if(checkedId == R.id.radioEstado) {

                    ArrayAdapter<CharSequence> adapterEstados = ArrayAdapter.createFromResource(getBaseContext(), R.array.estados, android.R.layout.simple_spinner_item);
                    adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapterEstados);

                    opcaoSelecionada = radioEstado.getText().toString();
                    opcaoSelecionada2 = spinner.getSelectedItem().toString();
                }


                Toast.makeText(ConsultarReflorestamentoActivity.this, ""+opcaoSelecionada, Toast.LENGTH_SHORT).show();

            }

        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                opcaoSelecionada2 = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        botaoConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(ConsultarReflorestamentoActivity.this, ""+opcaoSelecionada2, Toast.LENGTH_SHORT).show();

                if (opcaoSelecionada.equals("") || opcaoSelecionada2.equals("")){

                    Toast.makeText(ConsultarReflorestamentoActivity.this,
                            "É necessário usar o filtro de busca para consultar", Toast.LENGTH_SHORT).show();

                }else{

                    Intent intent = new Intent(ConsultarReflorestamentoActivity.this, ResultadoReflorestamentoActivity.class);
                    intent.putExtra("opção", opcaoSelecionada);
                    intent.putExtra("opção2", opcaoSelecionada2);
                    startActivity(intent);
                }

            }
        });

    }

}
