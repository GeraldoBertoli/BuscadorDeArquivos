package com.geraldobertoli.buscadordearquivos.modelo;

public class GerenciaTrabalho
{
    private Thread processo;
    private Trabalho trabalho;

    public GerenciaTrabalho(Trabalho trabalho)
    {
        this.trabalho = trabalho;
    }

    public void iniciaTrabalho()
    {
        if(processo != null)
        {
            if(!processo.isInterrupted())
            {
                processo.interrupt();
            }
        } else {
            processo = new Thread(trabalho);
        }

        processo.start();
    }

    public void paraTrabalho()
    {
        if(processo != null)
        {
            if(!processo.isInterrupted())
            {
                processo.interrupt();
            }
        } else {
            throw new NullPointerException("Erro: Processo não encontrado.");
        }
    }

    public void defineTrabalho(Trabalho trabalho)
    {
        this.trabalho = trabalho;
    }

    public Trabalho obtemTrabalho()
    {
        return this.trabalho;
    }
}