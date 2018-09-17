package br.com.ads6.reforestcontrol.helper;

import java.util.List;

import br.com.ads6.reforestcontrol.model.Reflorestamento;

public interface iReflorestamentoDAO {

    public boolean cadastrar(Reflorestamento reflorestamento);
    public List<Reflorestamento> listarPorAno(String op, String op2);
    public List<Reflorestamento> listarPorEstado(String op, String op2);
}
