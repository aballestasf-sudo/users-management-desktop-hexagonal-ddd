package com.jcaa.usersmanagement.application;

public class Survey {
    private int id;
    private int programId;
    private int totalEncuestados;
    private int aprobado;
    private int rechazos;
    private int indiferencias;
    private String fecha;

    public Survey(int id, int programId, int total, int aprob, int rech, int indif, String fecha) {
        if (aprob + rech + indif != total) {
            throw new InvSurveyExcept("La suma de respuestas no coincide con el total de encuestados");
        }
        if (total < 0 || aprob < 0 || rech < 0 || indif < 0) {
            throw new InvSurveyExcept("Los valores no pueden ser negativos");
        }
        this.id = id;
        this.programId = programId;
        this.totalEncuestados = total;
        this.aprobado = aprob;
        this.rechazos = rech;
        this.indiferencias = indif;
        this.fecha = fecha;
    }

    public double porcentajeAprobado() {
        return (double) aprobado / totalEncuestados * 100;
    }

    public double porcentajeRechazo() {
        return (double) rechazos / totalEncuestados * 100;
    }

    public double porcentajeIndiferencia() {
        return (double) indiferencias / totalEncuestados * 100;
    }

    // Getters
    public int getId() { return id; }
    public int getProgramId() { return programId; }
    public int getTotalEncuestados() { return totalEncuestados; }
    public int getAprobado() { return aprobado; }
    public int getRechazos() { return rechazos; }
    public int getIndiferencias() { return indiferencias; }
    public String getFecha() { return fecha; }

    public CharSequence getTitle() {
        return null;
    }
}
