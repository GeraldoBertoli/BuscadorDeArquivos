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
        processo = new Thread(trabalho);
        processo.start();
    }

    public void paraTrabalho()
    {
        try 
        {
            processo.interrupt();
        } catch (Exception e) 
        {
            System.err.println("Erro: Não existe nenhum trabalho em execução.");
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