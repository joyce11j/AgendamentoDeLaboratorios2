package ifpb.edu.br.entidades;
import javax.swing.*;
import java.awt.*;

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
        JButton btnSemAnt = new JButton("Semana Anterior");
        JButton btnProxSem = new JButton("Próxima Semana");

        navegacaoPanel.add(btnSemAnt);
        navegacaoPanel.add(btnProxSem);

        panel.add(new JLabel("Horário/Dia", SwingConstants.CENTER));

        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        for (int i = 0; i < dias.length; i++) {
            labelsDias[i] = new JLabel("", SwingConstants.CENTER);
            panel.add(labelsDias[i]);
        }

        String[] horarios = {"07:00h - 7:50h", "7:50h - 08:40h", "08:40h - 09:30h", "09:50h - 10:40h",
                "10:40h - 11:30h", "11:30h - 12:20h"};

        for (int i = 0; i < horarios.length; i++) {
            JLabel labelHorario = new JLabel(horarios[i], SwingConstants.CENTER);
            panel.add(labelHorario);

            for (int j = 0; j < dias.length; j++) {
                JButton botao = new JButton(" ");
                boolean ocupado = calendario.getBlocoAtual().getHorario(i, j);
                botao.setBackground(ocupado ? Color.RED : Color.GREEN);
                int finalI = i;
                int finalJ = j;
                botao.addActionListener(e -> {
                    JButton acaoCor = (JButton) e.getSource();
                    int linha = finalI;
                    int coluna = finalJ;
                    if (acaoCor.getBackground().equals(Color.GREEN)) {
                        acaoCor.setBackground(Color.RED);
                        calendario.getBlocoAtual().setHorario(linha, coluna, true);
                    } else {
                        acaoCor.setBackground(Color.GREEN);
                        calendario.getBlocoAtual().setHorario(linha, coluna, false);
                    }
                });
                panel.add(botao);
            }
        }

        btnSemAnt.addActionListener(e -> {
            calendario.semanaAnterior();
            atualizarDiasDaSemana();
            atualizarBlocos();
        });

        btnProxSem.addActionListener(e -> {
            calendario.proximaSemana();
            atualizarDiasDaSemana();
            atualizarBlocos();
        });

        this.add(navegacaoPanel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        atualizarDiasDaSemana();
        atualizarBlocos();
    }

    protected void atualizarDiasDaSemana() {
        String[] diasAtualizados = calendario.getDiasDaSemana();
        for (int i = 0; i < labelsDias.length; i++) {
            labelsDias[i].setText(diasAtualizados[i]);
        }
    }

    private void atualizarBlocos() {
        Component[] componentes = ((JPanel) this.getComponent(1)).getComponents();
        BlocoDeHorario blocoAtual = calendario.getBlocoAtual();

        int indice = 0;

        for (Component componente : componentes) {
            if (componente instanceof JButton) {
                int linha = (indice / 5) % 6;
                int coluna = indice % 5;
                JButton botao = (JButton) componente;
                boolean ocupado = blocoAtual.getHorario(linha, coluna);
                botao.setBackground(ocupado ? Color.RED : Color.GREEN);
                indice++;
            }
        }
    }
}
