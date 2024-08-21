package ifpb.edu.br.entidades;

import ifpb.edu.br.entidades.CalendarioSemanal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCalendario extends JPanel {
    private CalendarioSemanal calendario;
    private JLabel[] labelsDias;

    public JanelaCalendario(CalendarioSemanal calendario) {
        this.calendario = calendario;
        labelsDias = new JLabel[5];

        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 6));

        JPanel navegacaoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel.add(new JLabel("Horário/Dia", SwingConstants.CENTER));

        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        for (int i = 0; i < dias.length; i++) {
            labelsDias[i] = new JLabel("", SwingConstants.CENTER);
            panel.add(labelsDias[i]);
        }

        String[] horarios = {"07:00h - 07:50h", "07:50h - 08:40h", "08:40h - 09:30h", "09:50h - 10:40h",
                "10:40h - 11:30h", "11:30h - 12:20h"};

        for (int i = 0; i < horarios.length; i++) {
            JLabel labelHorario = new JLabel(horarios[i], SwingConstants.CENTER);
            panel.add(labelHorario);

            for (int j = 0; j < dias.length; j++) {
                JButton botao = new JButton(" ");
                boolean ocupado = calendario.getBlocoAtual().getHorario(i, j);
                botao.setBackground(ocupado ? Color.RED : Color.GREEN);
                botao.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton acaoCor = (JButton) e.getSource();
                        if (acaoCor.getBackground().equals(Color.GREEN)) {
                            acaoCor.setBackground(Color.RED);
                        } else {
                            acaoCor.setBackground(Color.GREEN);
                        }
                    }
                });
                panel.add(botao);
            }
        }

        this.add(navegacaoPanel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        atualizarDiasDaSemana();
    }

    public void atualizarDiasDaSemana() {
        String[] diasAtualizados = calendario.getDiasDaSemana();
        for (int i = 0; i < labelsDias.length; i++) {
            labelsDias[i].setText(diasAtualizados[i]);
        }
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JanelaCalendario janela = new JanelaCalendario(new CalendarioSemanal());
        janela.mostrar();
    }
}
