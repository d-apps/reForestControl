package br.com.ads6.reforestcontrol.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ads6.reforestcontrol.R;
import br.com.ads6.reforestcontrol.helper.DbHelper;
import br.com.ads6.reforestcontrol.helper.ReflorestamentoDAO;
import br.com.ads6.reforestcontrol.model.Reflorestamento;

public class ResultadoReflorestamentoActivity extends AppCompatActivity {

    private List<Reflorestamento> listaReflorestamento = new ArrayList<>();

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_reflorestamento);

        context = this;


        // Pegando referencia do TableLayout
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tablelayout);

        // Adicionar o header na row
        TableRow rowHeader = new TableRow(context);
        rowHeader.setBackgroundColor(Color.parseColor("#3cb371"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        // Cria uma string oom os titulos da row
        String[] headerText = {"Ano", "Estado", "Nº Árv. Cortadas", "Volume", "Arv. Repostas", "Valor"};
        for (String c : headerText) {

            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(12);
            tv.setTextColor(getResources().getColor(R.color.colorBlack));
            tv.setTypeface(Typeface.DEFAULT_BOLD);
            tv.setPadding(3, 3, 3, 3);
            tv.setText(c);
            rowHeader.addView(tv);
        }

        tableLayout.addView(rowHeader);

        Intent intent = getIntent();
        String op = intent.getStringExtra("opção");
        String op2 = intent.getStringExtra("opção2");


        Toast.makeText(context, ""+op, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, ""+op2, Toast.LENGTH_SHORT).show();


        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        db.beginTransaction();

        String consulta = "";

        try {
            //Consulta todos os bancos
            //String selectQuery = "SELECT * FROM " + DbHelper.TABELA_REFLORESTAMENTO;

            /*
            if( op.equals("Ano")){
                consulta= "SELECT * FROM " +
                        DbHelper.TABELA_REFLORESTAMENTO +
                        " WHERE ano = " +op2;
            }else if(op.equals("Estado")){
                consulta= "SELECT * FROM " + DbHelper.TABELA_REFLORESTAMENTO + " WHERE estado = " +op2;
            }
            */

            switch (op){

                case "Ano":
                    consulta= "SELECT * FROM " + DbHelper.TABELA_REFLORESTAMENTO + " WHERE ano = " +op2;
                    break;

                case "Estado":
                    consulta= "SELECT * FROM " + DbHelper.TABELA_REFLORESTAMENTO + " WHERE estado = "+op2;
                    break;

            }

            //Cursor cursor = db.rawQuery(selectQuery, null);
            Cursor cursor = db.rawQuery(consulta, null);


            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {

                    // Le os dados das colunas
                    String outlet_Ano = cursor.getString(cursor.getColumnIndex("ano"));
                    String outlet_Estado = cursor.getString(cursor.getColumnIndex("estado"));
                    int outlet_NumArvoresCortadas = cursor.getInt(cursor.getColumnIndex("numArvoresCortadas"));
                    String outlet_Volume = cursor.getString(cursor.getColumnIndex("volume"));
                    int outlet_qtdArvoresaSeremRepostas = cursor.getInt(cursor.getColumnIndex("qtdArvoresaSeremRepostas"));
                    double outlet_valorAserPago = cursor.getDouble(cursor.getColumnIndex("valoraSerPagar"));


                    // Seta os dados nas colunas do TableLayout
                    TableRow row = new TableRow(context);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                    //Cria um array de string para preencher a tabela


                   String[] colText = {outlet_Ano, outlet_Estado, String.valueOf(outlet_NumArvoresCortadas), outlet_Volume,
                            String.valueOf(outlet_qtdArvoresaSeremRepostas), String.valueOf(outlet_valorAserPago)};

                    for (String text : colText) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(12);
                        tv.setPadding(1, 1, 1, 1);
                        tv.setText(text);
                        row.addView(tv);
                    }
                    tableLayout.addView(row);

                }
            }
            db.setTransactionSuccessful();

        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            db.endTransaction();
            ;

            db.close();
        }


    }


    public void carregarDadosReforestamentoAno(){

        //Listar os dados
        ReflorestamentoDAO reflorestamentoDAO = new ReflorestamentoDAO(getApplicationContext());

    }

    public void carregarDadosReforestamentoEstado(){

        //Listar os dados
        ReflorestamentoDAO reflorestamentoDAO = new ReflorestamentoDAO(getApplicationContext());



    }

}
