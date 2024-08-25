package ifpb.edu.br.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarioSemanal {
    private List<BlocoDeHorario> blocosDeHorario;
    private int semanaAtual;

    public CalendarioSemanal() {
        blocosDeHorario = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            blocosDeHorario.add(new BlocoDeHorario());
        }
        Calendar calendar = Calendar.getInstance();
        semanaAtual = calendar.get(Calendar.WEEK_OF_YEAR) - 1;
    }

    public BlocoDeHorario getBlocoAtual() {
        return blocosDeHorario.get(semanaAtual);
    }

    public void semanaAnterior() {
        if (semanaAtual > 0) {
            semanaAtual--;
        }
    }

    public void proximaSemana() {
        if (semanaAtual < 51) {
            semanaAtual++;
        }
    }

    public String[] getDiasDaSemana() {
        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.WEEK_OF_YEAR, semanaAtual + 1);
        tempCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        for (int i = 0; i < dias.length; i++) {
            String diaComNumero = dias[i] + " - " + tempCalendar.get(Calendar.DAY_OF_MONTH);
            dias[i] = diaComNumero;
            tempCalendar.add(Calendar.DATE, 1);
        }
        return dias;
    }
}
