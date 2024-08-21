package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ComponentePersonalizado extends JPanel {
    public ComponentePersonalizado() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 50;
        c.ipady = 25;

        BlocoHorario blocoHorario = new BlocoHorario();
        String[] diasDaSemana = blocoHorario.getDiaDaSemana();
        String[] horarios = blocoHorario.getHorarios();

        for (int coluna = 0; coluna < diasDaSemana.length; coluna++) {
            c.gridx = coluna + 1; // começa em 1 para deixar a primeira coluna para os horários
            c.gridy = 0; // cabeçalho na linha 0
            JLabel labelDia = new JLabel(diasDaSemana[coluna], SwingConstants.CENTER);
            this.add(labelDia, c);
        }

        // Adiciona os horários na primeira coluna
        for (int linha = 0; linha < horarios.length; linha++) {
            c.gridx = 0; // primeira coluna para os horários
            c.gridy = linha + 1; // começa em 1 para deixar a primeira linha para os dias da semana
            JLabel labelHorario = new JLabel(horarios[linha], SwingConstants.CENTER);
            this.add(labelHorario, c);
        }

        boolean[][] blocosDeHorario = new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, false},
                {true, false, false, false, false},
                {true, false, false, true, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, true, false},
                {false, false, false, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };

        for (int linha = 0; linha < horarios.length; linha++) {
            for (int coluna = 0; coluna < diasDaSemana.length; coluna++) {
                c.gridx = coluna + 1;
                c.gridy = linha + 1;

                JButton button = new JButton();
                if (blocosDeHorario[linha][coluna]) {
                    button.setBackground(new Color(0xFFCBCB));
                } else {
                    button.setBackground(new Color(0xCBFFCB));
                }

                button.setBorder(BorderFactory.createLineBorder(Color.black));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Bloco selecionado: " + horarios[c.gridy - 1] + " - " + diasDaSemana[c.gridx - 1]);
                    }
                });

                this.add(button, c);
            }
        }
    }

}
