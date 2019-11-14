package com.geraldobertoli.buscadordearquivos;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.geraldobertoli.buscadordearquivos.visao.PrincipalUI;

public class App {
    /**
     * Software para cópia de arquivos
     * 
     * @author Geraldo Atilio Bertoli
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new PrincipalUI("Buscador de Arquivos");
    }
}
