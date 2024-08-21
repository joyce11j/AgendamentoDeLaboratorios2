package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastro extends JPanel {
    private JLabel labelMatricula;
    private JLabel labelNome;
    private JLabel labelSenha;
    private JLabel labelDisciplina;
    private JTextField textDisciplina;
    private List<Disciplina> disciplinas;
    private JTextField textMatricula;
    private JTextField textNome;
    private JPasswordField textSenha;
    private JButton btnCadastrar;
    private JButton btnAdicionar;
    private JTextArea areaDescricao;

    public TelaCadastro() {
        disciplinas = new ArrayList<>();
        configurar();
    }

    public void configurar() {
        this.setBackground(new Color(0xFFF8B8D9, true));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelTitulo = new JLabel("Cadastro");

        labelNome = new JLabel("Nome:");
        textNome = new JTextField(15); // Tamanho fixo para o JTextField

        labelMatricula = new JLabel("Matrícula:");
        textMatricula = new JTextField(15); // Tamanho fixo para o JTextField

        labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(15); // Tamanho fixo para o JPasswordField

        labelDisciplina = new JLabel("Disciplina: ");
        textDisciplina = new JTextField(15); // Tamanho fixo para o JTextField

        btnAdicionar = new JButton("+");
        btnAdicionar.setBackground(new Color(0x9D1888));
        btnAdicionar.setForeground(new Color(0xFFFFFF));

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(0x9D1888));
        btnCadastrar.setForeground(new Color(0xFFFFFF));

        areaDescricao = new JTextArea(10, 20);  // Inicializar a JTextArea com tamanho fixo
        areaDescricao.setEditable(false);  // Tornar não editável
        areaDescricao.setLineWrap(true);   // Quebra de linha automática
        areaDescricao.setWrapStyleWord(true);

        // Configuração do título
        c.insets = new Insets(10, 10, 10, 10); // Margens ao redor dos componentes
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER; // Centralizar o título
        this.add(labelTitulo, c);

        // Configuração do nome
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1; // quantidade de colunas ocupadas
        c.anchor = GridBagConstraints.LINE_END; // Alinhar o rótulo à direita
        this.add(labelNome, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START; // Alinhar o campo de texto à esquerda
        this.add(textNome, c);

        // Configuração da matrícula
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelMatricula, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textMatricula, c);

        // Configuração da senha
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelSenha, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textSenha, c);

        // Configuração da disciplina
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelDisciplina, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textDisciplina, c);

        // Configuração do botão adicionar
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(btnAdicionar, c);

        // Configuração da área de descrição
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        this.add(new JScrollPane(areaDescricao), c);

        // Configuração do botão cadastrar
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2; // Botão ocupa duas colunas
        c.anchor = GridBagConstraints.CENTER; // Centralizar o botão
        this.add(btnCadastrar, c);

        // Adicionar ação ao botão adicionar
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeDisciplina = textDisciplina.getText().trim();
                if (!nomeDisciplina.isEmpty()) {
                    Disciplina novaDisciplina = new Disciplina(nomeDisciplina);
                    disciplinas.add(novaDisciplina);
                    areaDescricao.append(novaDisciplina.getNome() + "\n");  // Exibir disciplina na JTextArea
                    textDisciplina.setText("");  // Limpar o campo de texto após adicionar
                } else {
                    JOptionPane.showMessageDialog(TelaCadastro.this, "Por favor, insira o nome da disciplina.");
                }
            }
        });
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
