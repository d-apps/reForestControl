package br.com.ads6.reforestcontrol.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TREETORAH";
    public static String TABELA_REFLORESTAMENTO = "reflorestamento";


    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Criação das tabelas

        String sql_REFLORESTAMENTOS = "CREATE TABLE IF NOT EXISTS " + TABELA_REFLORESTAMENTO
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " estado VARCHAR , "
                + " ano INT , "
                + " numArvoresCortadas VARCHAR , "
                + " volume DECIMAL , "
                + " valoraSerPagar DECIMAL , "
                + " qtdArvoresaSeremRepostas INT); ";

        //Criação das tabelas no banco de dados
        try {
            db.execSQL(sql_REFLORESTAMENTOS);
            Log.i("INFO DB", "Tabelas criadas com sucesso");

        } catch (Exception e){
            Log.i("INFO DB", "Falha em criar as tabelas" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
