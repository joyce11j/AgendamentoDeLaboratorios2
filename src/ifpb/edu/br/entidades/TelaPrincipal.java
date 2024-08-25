package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;

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
        janelaCalendario = new JanelaCalendario(calendarioSemanal);

        configurar();
    }

    public void configurar() {
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        btnAnterior = new JButton("<");
        btnPosterior = new JButton(">");

        jPanel.add(btnAnterior);
        jPanel.add(btnPosterior);

        btnAnterior.addActionListener(e -> {
            calendarioSemanal.semanaAnterior();
            janelaCalendario.atualizarDiasDaSemana();
        });

        btnPosterior.addActionListener(e -> {
            calendarioSemanal.proximaSemana();
            janelaCalendario.atualizarDiasDaSemana();
        });

        campoDeBusca = new JTextField("Pesquise a semana", 20);

        JPanel topoPanel = new JPanel(new BorderLayout());
        topoPanel.add(campoDeBusca, BorderLayout.CENTER);
        topoPanel.add(jPanel, BorderLayout.EAST);

        this.add(topoPanel, BorderLayout.NORTH);
        this.add(janelaCalendario, BorderLayout.CENTER);
    }

    public void addProfessor(Professor p) {
        // Método para adicionar um professor (não implementado aqui)
    }
}
