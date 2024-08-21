package ifpb.edu.br.entidades;

import ifpb.edu.br.entidades.TelaCadastro;
import ifpb.edu.br.entidades.TelaLogin;
import ifpb.edu.br.entidades.TelaPrincipal;

import javax.swing.*;
import java.awt.*;

public class GerenciadorDeTelas extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private TelaLogin telaLogin;
    private TelaPrincipal telaPrincipal;
    private TelaCadastro telaCadastro;

    public GerenciadorDeTelas() {
        // Configuração do layout e painel principal
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Criar as instâncias das telas
        telaLogin = new TelaLogin();
        telaPrincipal = new TelaPrincipal();
        telaCadastro = new TelaCadastro();

        painelPrincipal.add(telaLogin, "TelaLogin");
        painelPrincipal.add(telaPrincipal, "TelaPrincipal");
        painelPrincipal.add(telaCadastro, "TelaCadastro");

        telaLogin.addEntrarListener(e -> cardLayout.show(painelPrincipal, "TelaPrincipal"));
        telaLogin.addCadastrarListener(e -> cardLayout.show(painelPrincipal, "TelaCadastro"));
        telaCadastro.addCadastrarListener(e -> cardLayout.show(painelPrincipal, "TelaPrincipal"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.add(painelPrincipal);
        this.setVisible(true);

        // Exibir a tela de Login inicialmente
        cardLayout.show(painelPrincipal, "TelaLogin");
    }

    // Método main para iniciar a aplicação
    public static void main(String[] args) {
        new GerenciadorDeTelas();
    }
}
