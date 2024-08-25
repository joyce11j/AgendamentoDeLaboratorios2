package ifpb.edu.br.entidades;
public class BlocoDeHorario {
    private boolean[][] bloco;

    public BlocoDeHorario() {
        bloco = new boolean[6][5];
    }

    public boolean getHorario(int linha, int coluna) {
        return bloco[linha][coluna];
    }

    public void setHorario(int linha, int coluna, boolean ocupado) {
        bloco[linha][coluna] = ocupado;
    }
}
