package com.geraldobertoli.buscadordearquivos.visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import com.geraldobertoli.buscadordearquivos.controle.GerenciaTrabalhoControle;
import com.geraldobertoli.buscadordearquivos.modelo.CopiaArquivosTrabalho;
import com.geraldobertoli.buscadordearquivos.modelo.ProgressoEvento;
import com.geraldobertoli.buscadordearquivos.modelo.Trabalho;

public class CopiaUI extends JDialog
{
    /**
     * Software para cópia de arquivos
     * @author Geraldo Atilio Bertoli
     */
    private static final long serialVersionUID = 1L;

    private JDialog dialogo;
    private JPanel painel;
    private JPanel painelBotao;

    private JLabel lblCopia;
    private JLabel lblTarefa;
    private JProgressBar pBarTarefa;
    private JButton btnCancelar;
    private List<String> listaArquivos;
    private String origem, destino;
    private GerenciaTrabalhoControle gerenciador;

    public CopiaUI(Frame janela, String titulo, Boolean modal, List<String> listaArquivos, String origem, String destino)
    {
        super(janela, titulo, modal);
        this.listaArquivos = listaArquivos;
        this.origem = origem;
        this.destino = destino;
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        montaJanela();

        Trabalho trabalho = new CopiaArquivosTrabalho(listaArquivos, origem, destino);
        trabalho.addObservadorProgresso(new ProgressoEvento()
        {

            @Override
            public void aoAtualizarProgresso(Trabalho trabalho, int progresso)
            {
                atualizaProgresso(progresso);
                if(obtemProgresso() == 100)
                {
                    dialogo.dispose();
                }
            }
            
        });
        
        this.gerenciador = new GerenciaTrabalhoControle(trabalho);
        this.gerenciador.iniciaTrabalho();
    }

    private void montaJanela()
    {
        this.dialogo = this;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setModal(true);
        this.setSize(new Dimension(480, 165));

        painel = new JPanel();
        this.setContentPane(painel);
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JPanel painelLblCopia = new JPanel();
        painelLblCopia.setLayout(new BoxLayout(painelLblCopia, BoxLayout.LINE_AXIS));
        lblCopia = new JLabel("COPIANDO");
        lblCopia.setFont(new Font(lblCopia.getName(), Font.PLAIN, 18));
        painelLblCopia.add(lblCopia);
        painel.add(painelLblCopia);

        painel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel painelLblTarefa = new JPanel();
        painelLblTarefa.setLayout(new BoxLayout(painelLblTarefa, BoxLayout.LINE_AXIS));
        lblTarefa = new JLabel(" ");
        painelLblTarefa.add(lblTarefa);
        painelLblTarefa.add(Box.createHorizontalGlue());
        painel.add(painelLblTarefa);


        painel.add(Box.createRigidArea(new Dimension(0, 10)));

        pBarTarefa = new JProgressBar(0, 100);
        pBarTarefa.setStringPainted(true);
        painel.add(pBarTarefa);
        pBarTarefa.setValue(0);

        painel.add(Box.createRigidArea(new Dimension(0, 10)));

        painelBotao = new JPanel();
        painelBotao.setLayout(new BoxLayout(painelBotao, BoxLayout.LINE_AXIS));
        painel.add(painelBotao);

        btnCancelar = new JButton("Cancelar");
        painelBotao.add(Box.createHorizontalGlue());
        painelBotao.add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gerenciador.paraTrabalho();
                dialogo.dispose();
            }
        });

    }

    protected void atualizaProgresso(int progresso)
    {
        pBarTarefa.setString(progresso + "% concluído");
        pBarTarefa.setValue(progresso);
    }
    
    protected int obtemProgresso()
    {
        return pBarTarefa.getValue();
    }
}