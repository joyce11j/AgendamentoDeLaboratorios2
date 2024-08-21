package ifpb.edu.br.entidades;

public class BlocoDeHorario {
    private boolean[][] bloco;

    public BlocoDeHorario() {
        bloco = new boolean[][] {
                {false, false, false, false, true},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };
    }

    public boolean getHorario(int linha, int coluna) {
        return bloco[linha][coluna];
    }

    public void setHorario(int linha, int coluna, boolean ocupado) {
        bloco[linha][coluna] = ocupado;
    }

    public static void main(String[] args) {
        BlocoDeHorario verificar = new BlocoDeHorario();

        // verificar.setHorario(0, true);
        //
        // boolean status = verificar.getHorario(0);
        // System.out.println("Horário na linha 0 ocupado? " + status);

    }
}