/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Entidades;

/**
 *
 * @author criss
 */
public class inscripcion {

    private int idInscripto;
    private double nota;
    private alumno idAlumno;
    private materia idMateria;

    public inscripcion() {
    }

    public inscripcion(int idInscripto, double nota, alumno idAlumno, materia idMateria) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "Inscripcion: " + "ID Inscripto: " + idInscripto + ", Nota: " + nota + ", ID Alumno: " + idAlumno + ", ID Materia: " + idMateria ;
    }

}