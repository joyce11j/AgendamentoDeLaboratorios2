package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JPanel {
    private JLabel labelMatricula;
    private JLabel labelSenha;
    private JTextField textMatricula;
    private JPasswordField textSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;

    public TelaLogin() {
        configurar();
    }

    public void configurar() {
        this.setBackground(new Color(0xFFF8B8D9, true));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelTitulo = new JLabel("Login");

        labelMatricula = new JLabel("Matrícula:");
        textMatricula = new JTextField(15);
        labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(15);
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(0x9D1888));
        btnEntrar.setForeground(new Color(0xFFFFFF));
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(0x9D1888));
        btnCadastrar.setForeground(new Color(0xFFFFFF));

        // Layout dos componentes
        c.insets = new Insets(10, 10, 10, 10);  // Espaçamento entre componentes

        // Configuração do título
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;  // Título ocupa duas colunas
        c.anchor = GridBagConstraints.CENTER;  // Centralizar o título
        this.add(labelTitulo, c);

        // Configuração da matrícula
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;  // Restabelecer a largura para os componentes seguintes
        c.anchor = GridBagConstraints.LINE_END;  // Alinhar o rótulo à direita
        this.add(labelMatricula, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;  // Alinhar o campo de texto à esquerda
        this.add(textMatricula, c);

        // Configuração da senha
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;  // Alinhar o rótulo à direita
        this.add(labelSenha, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;  // Alinhar o campo de texto à esquerda
        this.add(textSenha, c);

        // Configuração dos botões
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;  // Botões ocupam duas colunas
        c.anchor = GridBagConstraints.CENTER;  // Centralizar os botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnEntrar);
        buttonPanel.add(btnCadastrar);
        this.add(buttonPanel, c);

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = textMatricula.getText();
                String senha = new String(textSenha.getPassword());

                if (!matricula.isEmpty() && !senha.isEmpty()) {
                    JOptionPane.showMessageDialog(btnEntrar, "Informações válidas!!");
                } else {
                    JOptionPane.showMessageDialog(btnEntrar, "Informações inválidas!!");
                }
            }
        });
    }
    public void addEntrarListener(ActionListener listener) {
        btnEntrar.addActionListener(listener);
    }
    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
