package com.geraldobertoli.buscadordearquivos.visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
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

public class CopiaUI extends JDialog
{
    /**
     * Software para cópia de arquivos
     * @author Geraldo Atilio Bertoli
     */
    private static final long serialVersionUID = 1L;

    private JPanel painel;
    private JPanel painelBotao;

    private JLabel lblCopia;
    private JLabel lblTarefa;
    private JProgressBar pBarTarefa;
    private JButton btnCancelar;

    public CopiaUI(Frame janela, String titulo, Boolean modal)
    {
        super(janela, titulo, modal);
        montaJanela();
    }

    private void montaJanela()
    {
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
        atualizaProgresso(0);

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
                //A implementar
            }
        });

    }

    public void atualizaProgresso(int progresso)
    {
        pBarTarefa.setString(progresso + "% concluído");
        pBarTarefa.setValue(progresso);
    }

    public int consultaProgresso()
    {
        return pBarTarefa.getValue();
    }
}