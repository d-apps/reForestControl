package br.com.ads6.reforestcontrol.model;

import java.io.Serializable;

public class Reflorestamento implements Serializable {

    private int id;
    private String estado;
    private String ano;
    private int numeroArvoreCortadas;
    private double volumeM3;
    private int qtdArvoresaSeremRepostas;
    private double valoraSerPago;

    public void cadastrarReflorestamento(){

    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getNumeroArvoreCortadas() {
        return numeroArvoreCortadas;
    }

    public void setNumeroArvoreCortadas(int numeroArvoreCortadas) {
        this.numeroArvoreCortadas = numeroArvoreCortadas;
    }

    public double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public int getQtdArvoresaSeremRepostas() {
        return qtdArvoresaSeremRepostas;
    }

    public void setQtdArvoresaSeremRepostas(int qtdArvoresaSeremRepostas) {
        this.qtdArvoresaSeremRepostas = qtdArvoresaSeremRepostas;
    }

    public double getValoraSerPago() {
        return valoraSerPago;
    }

    public void setValoraSerPago(double valoraSerPago) {
        this.valoraSerPago = valoraSerPago;
    }


}
