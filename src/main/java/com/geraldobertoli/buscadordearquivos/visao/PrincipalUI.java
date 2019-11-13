package com.geraldobertoli.buscadordearquivos.visao;

import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;



public class PrincipalUI extends JFrame
{

    /**
     * Software para cópia de arquivos
     * @author Geraldo Atilio Bertoli
     */
    private static final long serialVersionUID = 1L;

    private JFrame janela;

    private JPanel painelPrincipal;
    private JPanel painelNorte;
    private JPanel painelLblOrigem;
    private JPanel painelOrigem;
    private JPanel painelCentral;
    private JPanel painelSul;
    private JPanel painelLblSul;
    private JPanel painelDest;
    private JPanel painelBotoes;

    private JLabel lblOrigem;
    private JButton btnCarregaOrigem;
    private JTextField txtOrigem;
    private JTextArea textXML;
    private JTextArea textFaltando;
    private JLabel lblDest;
    private JButton btnCarregaDest;
    private JTextField txtDest;
    private JButton btnIniciar;
    private JFileChooser chooser;

    
    public PrincipalUI(String titulo)
    {
        super(titulo);
        montaJanela();
        this.setVisible(true);
    }

    private void montaJanela()
    {
        janela = this;
        preparaJanela();
        preparaPainelPrincipal();
    }

    private void preparaJanela()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(720, 480));
        this.setSize(new Dimension(920, 540));
    }

    private void preparaPainelPrincipal()
    {
        painelPrincipal = new JPanel();
        this.add(painelPrincipal);
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        preparaPainelNorte();
        preparaCaixasTexto();
        preparaPainelSul();
    }

    private void preparaPainelNorte()
    {
        painelNorte = new JPanel();
        painelNorte.setLayout(new BoxLayout(painelNorte, BoxLayout.PAGE_AXIS));
        painelPrincipal.add(painelNorte, BorderLayout.PAGE_START);

        painelLblOrigem = new JPanel();
        painelLblOrigem.setLayout(new BoxLayout(painelLblOrigem, BoxLayout.LINE_AXIS));
        painelNorte.add(painelLblOrigem);

        lblOrigem = new JLabel("Pasta de origem");
        painelLblOrigem.add(Box.createRigidArea(new Dimension(98, 0)));
        painelLblOrigem.add(lblOrigem);
        painelLblOrigem.add(Box.createHorizontalGlue());

        painelOrigem = new JPanel();
        painelOrigem.setLayout(new BoxLayout(painelOrigem, BoxLayout.LINE_AXIS));
        painelNorte.add(painelOrigem);

        btnCarregaOrigem = new JButton("Carregar");
        painelOrigem.add(btnCarregaOrigem);
        btnCarregaOrigem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                chooser = new JFileChooser(); 
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Selecione a pasta de origem");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                //
                // desabilita a opção "All files".
                //
                chooser.setAcceptAllFileFilterUsed(false);
                //    
                if (chooser.showOpenDialog(janela) == JFileChooser.APPROVE_OPTION)
                {
                    //txtOrigem.setText(chooser.getCurrentDirectory().getPath());
                    txtOrigem.setText(chooser.getSelectedFile() + "");
                }
            }
        });

        painelOrigem.add(Box.createRigidArea(new Dimension(10, 0)));

        txtOrigem = new JTextField();
        txtOrigem.setEditable(false);
        painelOrigem.add(txtOrigem);
    }

    private void preparaCaixasTexto()
    {

        painelCentral = new JPanel();
        painelCentral.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        painelCentral.setLayout(new GridLayout(1, 2, 5, 0));
        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        textXML = new JTextArea();
        textXML.setBorder(new LineBorder(Color.GRAY));
        painelCentral.add(new JScrollPane(textXML));

        textFaltando = new JTextArea();
        //textFaltando.setEditable(false);
        textFaltando.setBorder(new LineBorder(Color.GRAY));
        painelCentral.add(new JScrollPane(textFaltando));
    }

    private void preparaPainelSul()
    {
        painelSul = new JPanel();
        painelSul.setLayout(new BoxLayout(painelSul, BoxLayout.PAGE_AXIS));
        painelPrincipal.add(painelSul, BorderLayout.PAGE_END);

        painelLblSul = new JPanel();
        painelLblSul.setLayout(new BoxLayout(painelLblSul, BoxLayout.LINE_AXIS));
        painelSul.add(painelLblSul);

        lblDest = new JLabel("Pasta de destino");
        painelLblSul.add(Box.createRigidArea(new Dimension(98, 0)));
        painelLblSul.add(lblDest);
        painelLblSul.add(Box.createHorizontalGlue());

        painelDest = new JPanel();
        painelDest.setLayout(new BoxLayout(painelDest, BoxLayout.LINE_AXIS));
        painelSul.add(painelDest);

        btnCarregaDest = new JButton("Carregar");
        painelDest.add(btnCarregaDest);
        btnCarregaDest.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                chooser = new JFileChooser(); 
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Selecione a pasta de destino");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                //
                // desabilita a opção "All files".
                //
                chooser.setAcceptAllFileFilterUsed(false);
                //    
                if (chooser.showOpenDialog(janela) == JFileChooser.APPROVE_OPTION)
                { 
                    txtDest.setText(chooser.getSelectedFile() + "");
                }
            }
        });

        painelDest.add(Box.createRigidArea(new Dimension(10, 0)));

        txtDest = new JTextField();
        txtDest.setEditable(false);
        painelDest.add(txtDest);

        painelSul.add(Box.createRigidArea(new Dimension(0, 10)));

        painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.LINE_AXIS));
        painelSul.add(painelBotoes);

        btnIniciar = new JButton("Iniciar");
        painelBotoes.add(Box.createHorizontalGlue());
        painelBotoes.add(btnIniciar);
        btnIniciar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String [] temp = textXML.getText().split("\n");
                List<String> listaArquivos = new ArrayList<String>();
                for(int i = 0; i < temp.length; i++)
                {
                    listaArquivos.add(temp[i]);
                }

                JDialog copia = new CopiaUI(janela, "Processo de cópia de arquivos", true, 
                    listaArquivos, txtOrigem.getText(), txtDest.getText());
                copia.setLocationRelativeTo(janela);
                copia.setVisible(true);
            }
        });
    }
}