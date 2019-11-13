package com.geraldobertoli.buscadordearquivos.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Trabalho implements Runnable
{
    private List<ProgressoEvento> observadores;
    private int progresso = 0;

    public abstract void run();

    public void addObservadorProgresso(ProgressoEvento observador)
    {
        if (observadores == null)
        {
            observadores = new ArrayList<ProgressoEvento>();
        }
        observadores.add(observador);
    }

    @SuppressWarnings("unused")
    protected void notificaObservadoresProgresso()
    {
        for (ProgressoEvento obs : observadores) {
            obs.aoAtualizarProgresso(this, progresso);
        }
    }

    protected void setProgresso(int progresso)
    {
        this.progresso = progresso;
    }
}