package ifpb.edu.br.entidades;

import java.util.List;

public class Laboratorio {
    private String id;
    private List<BlocoDeHorario> blocosDeHorarios;

    public String getId(){
        return id;
    }

    public List<BlocoDeHorario> getBlocosDeHorarios() {
        return blocosDeHorarios;
    }

    public void setBlocosDeHorarios(List<BlocoDeHorario> blocosDeHorarios) {
        this.blocosDeHorarios = blocosDeHorarios;
    }

    public boolean horarioDisponivel(int horario, int dia){
        return true;
    }
    public void reservarHorario(int horario, int dia){

    }
}
