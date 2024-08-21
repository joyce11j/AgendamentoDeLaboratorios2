package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadastro extends JPanel {
    private JLabel labelMatricula;
    private JLabel labelNome;
    private JLabel labelSenha;
    private List<Disciplina> disciplina;
    private JTextField textMatricula;
    private JTextField textNome;
    private JTextField textSenha;
    private JButton btnCadastrar;
    public TelaCadastro() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelTitulo = new JLabel("Cadastro");
        labelNome = new JLabel("Nome:");
        textNome = new JTextField(15);
        labelMatricula = new JLabel("Matrícula:");
        textMatricula = new JTextField(15);
        labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(15);

        btnCadastrar = new JButton("Cadastrar");

        // Layout dos componentes
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        this.add(labelTitulo, c);

        c.gridy = 1;
        this.add(labelNome, c);

        c.gridx = 1;
        this.add(textNome, c);

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
        this.add(btnCadastrar, c);
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
