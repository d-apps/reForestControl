package br.com.ads6.reforestcontrol.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.ads6.reforestcontrol.model.Reflorestamento;

public class ReflorestamentoDAO implements iReflorestamentoDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public ReflorestamentoDAO(Context context) {

        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean cadastrar(Reflorestamento reflorestamento) {

        ContentValues cv = new ContentValues();
        cv.put("ano", reflorestamento.getAno());
        cv.put("estado", reflorestamento.getEstado());
        cv.put("numArvoresCortadas", reflorestamento.getNumeroArvoreCortadas());
        cv.put("volume", reflorestamento.getVolumeM3());
        cv.put("valoraSerPagar", reflorestamento.getValoraSerPago());
        cv.put("qtdArvoresaSeremRepostas", reflorestamento.getQtdArvoresaSeremRepostas());

        try{

            escreve.insert(DbHelper.TABELA_REFLORESTAMENTO, null, cv);
            Log.i("INFO", "Cadastro salvo com sucesso!!!");

        }catch (Exception e){

            Log.i("INFO", "Erro em cadastrar!!!" + e.getMessage());
            return false;
        }

        return false;
    }

    @Override
    public List<Reflorestamento> listarPorAno(String op, String op2) {

        List<Reflorestamento> reflorestamentos = new ArrayList<>();

        String sql = "SELECT ano,qtdArvoresRepostas, numArvoresCortadas, valoraSerPego, volume   FROM " + DbHelper.TABELA_REFLORESTAMENTO + ";";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){

            Reflorestamento reflorestamento = new Reflorestamento();

            String ano = c.getString(c.getColumnIndex("ano"));
            int arvoresRepostas = c.getInt(c.getColumnIndex("qtdArvoresRepostas"));
            int numeroArvoresCortadas = c.getInt(c.getColumnIndex("numArvoresCortadas"));
            double valoraSerPego = c.getDouble(c.getColumnIndex("valoraSerPego"));
            double volumeM3 = c.getDouble(c.getColumnIndex("volume"));

            reflorestamento.setAno(ano);
            reflorestamento.setQtdArvoresaSeremRepostas(arvoresRepostas);
            reflorestamento.setNumeroArvoreCortadas(numeroArvoresCortadas);
            reflorestamento.setValoraSerPago(valoraSerPego);
            reflorestamento.setVolumeM3(volumeM3);

            reflorestamentos.add(reflorestamento);

        }

        return reflorestamentos;
    }

    @Override
    public List<Reflorestamento> listarPorEstado(String op, String op2) {

        List<Reflorestamento> reflorestamentos = new ArrayList<>();

        String sql = "SELECT estado,qtdArvoresRepostas, numArvoresCortadas, valoraSerPego, volume FROM " + DbHelper.TABELA_REFLORESTAMENTO + ";";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()) {

            Reflorestamento reflorestamento = new Reflorestamento();

            String estado = c.getString(c.getColumnIndex("estado"));
            int arvoresRepostas = c.getInt(c.getColumnIndex("qtdArvoresRepostas"));
            int numeroArvoresCortadas = c.getInt(c.getColumnIndex("numArvoresCortadas"));
            double valoraSerPego = c.getDouble(c.getColumnIndex("valoraSerPego"));
            double volumeM3 = c.getDouble(c.getColumnIndex("volume"));

            reflorestamento.setEstado(estado);
            reflorestamento.setQtdArvoresaSeremRepostas(arvoresRepostas);
            reflorestamento.setNumeroArvoreCortadas(numeroArvoresCortadas);
            reflorestamento.setValoraSerPago(valoraSerPego);
            reflorestamento.setVolumeM3(volumeM3);

            reflorestamentos.add(reflorestamento);

        }

        return reflorestamentos;
    }
}
