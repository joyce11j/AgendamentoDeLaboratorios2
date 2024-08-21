package ifpb.edu.br.entidades;

public class BlocoHorario {
    private String DataInicio;
    private String DataFinal;
    private String[] diaDaSemana = {"Segunda","Terça", "Quarta", "Quinta", "Sexta"};
    private String[] horarios = {
            "07h00-07h50",
            "07h50-08h40",
            "08h40-09h30",
            "09h50-10h40",
            "10h40-11h30",
            "11h30-12h20",
            "13h50-14h40",
            "14h40-15h30",
            "15h50-16h40",
            "16h40-17h30"
    };

    public String getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(String dataInicio) {
        DataInicio = dataInicio;
    }

    public String getDataFinal() {
        return DataFinal;
    }

    public void setDataFinal(String dataFinal) {
        DataFinal = dataFinal;
    }

    public String[] getDiaDaSemana() {
        return diaDaSemana;
    }

    public String[] getHorarios() {
        return horarios;
    }
}
