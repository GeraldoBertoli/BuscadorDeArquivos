package com.geraldobertoli.buscadordearquivos.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopiaArquivosTrabalho extends Trabalho {
    private String origem, destino;
    List<String> arquivos;
    private int progresso;

    public CopiaArquivosTrabalho(List<String> arquivos, String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.arquivos = arquivos;
    }

    @Override
    public void run() {
        File origem = new File(this.origem);
        File destino = new File(this.destino);
        Arquivo arquivo = new Arquivo();
        List<File> lista = arquivo.listaArquivosOrigem(origem);
        List<File> listaCopia = new ArrayList<File>();

        for(String arq: arquivos)
        {
            for(File f: lista)
            {
                if(f.getName().contains(arq))
                {
                    listaCopia.add(f);
                }
            }
        }

        for (int i = 0; i < listaCopia.size(); i++) 
        {
            try {
                arquivo.copiaArquivo(listaCopia.get(i), destino);
                notificaObservadoresProgresso(((i * 100) / (listaCopia.size() - 1)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}