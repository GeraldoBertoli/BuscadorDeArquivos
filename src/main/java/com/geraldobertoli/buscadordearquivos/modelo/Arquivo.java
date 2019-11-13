package com.geraldobertoli.buscadordearquivos.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class Arquivo
{
    public List<File> listaArquivosOrigem(File pasta)
    {
        List<File> lista = new ArrayList<File>();

        for (File f: pasta.listFiles())
        {
            if(f.isDirectory())
            {
                lista.addAll(listaArquivosOrigem(f));
            } else {
                lista.add(f);
            }
        }

        return lista;
    }

    public void copiaArquivo(File origem, File destino) throws IOException
    {
        destino = new File(destino.getPath() + "/" + origem.getName());
        
        if (destino.exists())
        destino.delete();

        FileChannel origemChannel = null;
        FileChannel destinoChannel = null;  

        try {
            origemChannel = new FileInputStream(origem).getChannel();
            destinoChannel = new FileOutputStream(destino).getChannel();
            origemChannel.transferTo(0, origemChannel.size(), destinoChannel);
        } finally {
            if (origemChannel != null && origemChannel.isOpen())
                origemChannel.close();
            if (destinoChannel != null && destinoChannel.isOpen())
                destinoChannel.close();
        }
    }
}