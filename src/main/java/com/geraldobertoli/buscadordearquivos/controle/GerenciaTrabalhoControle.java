package com.geraldobertoli.buscadordearquivos.controle;

import com.geraldobertoli.buscadordearquivos.modelo.GerenciaTrabalho;
import com.geraldobertoli.buscadordearquivos.modelo.Trabalho;

public class GerenciaTrabalhoControle
{
    private GerenciaTrabalho gerenciadorTrabalho;

    public GerenciaTrabalhoControle(Trabalho trabalho)
    {
        this.gerenciadorTrabalho = new GerenciaTrabalho(trabalho);
    }

    public void iniciaTrabalho()
    {
        this.gerenciadorTrabalho.iniciaTrabalho();
    }

    public void paraTrabalho()
    {
        this.gerenciadorTrabalho.paraTrabalho();
    }
}