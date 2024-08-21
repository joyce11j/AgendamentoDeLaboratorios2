package ifpb.edu.br.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarioSemanal {
    private Calendar calendar;
    private List<BlocoDeHorario> blocos;
    private int semanaAtual;

    public CalendarioSemanal() {
        calendar = Calendar.getInstance();
        blocos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            blocos.add(new BlocoDeHorario());
        }
        semanaAtual = 0;
    }

    public String[] getDiasDaSemana() {
        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        Calendar tempCalendar = (Calendar) calendar.clone();
        tempCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String[] diasComNumeros = new String[dias.length];

        for (int i = 0; i < dias.length; i++) {
            diasComNumeros[i] = dias[i] + " - " + tempCalendar.get(Calendar.DAY_OF_MONTH);
            tempCalendar.add(Calendar.DATE, 1);
        }
        return diasComNumeros;
    }

    public BlocoDeHorario getBlocoAtual() {
        return blocos.get(semanaAtual);
    }

    public void semanaAnterior() {
        if (semanaAtual > 0) {
            semanaAtual--;
        }
    }

    public void proximaSemana() {
        if (semanaAtual < blocos.size() - 1) {
            semanaAtual++;
        }
    }
}

