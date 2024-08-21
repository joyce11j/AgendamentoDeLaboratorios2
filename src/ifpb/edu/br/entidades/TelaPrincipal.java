package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JPanel {

    private JPanel jPanel;
    private JTextField campoDeBusca;
    private ComponentePersonalizado componentePersonalizado;
    private JButton bntAnterior;
    private JButton bntPosterior;

    public TelaPrincipal() {
        this.setLayout(new BorderLayout());
        componentePersonalizado = new ComponentePersonalizado(); // Instância do ComponentePersonalizado
        configurar();
    }
    public void configurar(){
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        bntAnterior = new JButton("<");
        bntPosterior = new JButton(">");

        jPanel.add(bntAnterior);
        jPanel.add(bntPosterior);

        campoDeBusca = new JTextField("Pesquise a semana", 20);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.NORTH;
        this.add(campoDeBusca, c);

        // Adicionando o JPanel com os botões ao JFrame
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.NORTH;
        this.add(jPanel, c);

        // Adicionando o ComponentePersonalizado ao JFrame
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.CENTER;
        this.add(componentePersonalizado, c);
    }

    public void addProfessor(Professor p) {
    }
}

