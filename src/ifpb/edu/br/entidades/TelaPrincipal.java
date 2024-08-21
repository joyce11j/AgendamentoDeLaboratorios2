package ifpb.edu.br.entidades;

import ifpb.edu.br.entidades.CalendarioSemanal;
import ifpb.edu.br.entidades.JanelaCalendario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JPanel {

    private JPanel jPanel;
    private JTextField campoDeBusca;
    private JButton btnAnterior;
    private JButton btnPosterior;
    private CalendarioSemanal calendarioSemanal;
    private JanelaCalendario janelaCalendario;

    public TelaPrincipal() {
        this.setLayout(new BorderLayout());
        calendarioSemanal = new CalendarioSemanal();
        janelaCalendario = new JanelaCalendario(calendarioSemanal); // Passar o calendário para sincronização

        configurar();
    }

    public void configurar() {
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(248, 184, 217));

        btnAnterior = new JButton("<");
        btnPosterior = new JButton(">");

        jPanel.add(btnAnterior);
        jPanel.add(btnPosterior);

        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendarioSemanal.semanaAnterior();
                janelaCalendario.atualizarDiasDaSemana();
            }
        });

        btnPosterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendarioSemanal.proximaSemana();
                janelaCalendario.atualizarDiasDaSemana();
            }
        });

        campoDeBusca = new JTextField("Pesquise a semana", 20);

        // Adicionando o campo de busca e painel de botões ao topo da tela
        JPanel topoPanel = new JPanel(new BorderLayout());
        topoPanel.add(campoDeBusca, BorderLayout.CENTER);
        topoPanel.add(jPanel, BorderLayout.EAST);

        // Adicionando os componentes à TelaPrincipal
        this.add(topoPanel, BorderLayout.NORTH);
        this.add(janelaCalendario, BorderLayout.CENTER);
    }

    public void addProfessor(Professor p) {
        // Método para adicionar um professor (não implementado aqui)
    }
}
