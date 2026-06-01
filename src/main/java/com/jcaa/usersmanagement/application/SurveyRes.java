package domain;

public class SurveyRes {
    private int aprobado;
    private int rechazos;
    private int indiferencias;

    public SurveyRes(int aprob, int rech, int indif) {
        if (aprob < 0 || rech < 0 || indif < 0) {
            throw new InvSurveyExcept("Los valores no pueden ser negativos");
        }
        this.aprobado = aprob;
        this.rechazos = rech;
        this.indiferencias = indif;
    }

    public int totalRespuestas() {
        return aprobado + rechazos + indiferencias;
    }

    public int getAprobado() { return aprobado; }
    public int getRechazos() { return rechazos; }
    public int getIndiferencias() { return indiferencias; }
}
