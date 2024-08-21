package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaLogin extends JPanel {
    private JLabel labelMatricula;
    private JLabel labelSenha;
    private JTextField textMatricula;
    private JTextField textSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;

    public TelaLogin() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelTitulo = new JLabel("Login");

        labelMatricula = new JLabel("Matrícula:");
        textMatricula = new JTextField(15);
        labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(15);
        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");

        // Layout dos componentes
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        this.add(labelTitulo, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(labelMatricula, c);

        c.gridx = 1;
        this.add(textMatricula, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(labelSenha, c);

        c.gridx = 1;
        this.add(textSenha, c);

        c.gridx = 1;
        c.gridy = 4;
        this.add(btnEntrar, c);

        c.gridx = 2;
        c.gridy = 4;
        this.add(btnCadastrar, c);
    }

    public void addEntrarListener(ActionListener listener) {
        btnEntrar.addActionListener(listener);
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
