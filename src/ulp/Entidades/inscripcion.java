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
    private int nota;
    private alumno idAlumno;
    private materia idMateria;

    public inscripcion() {
    }

    public inscripcion(int idInscripto, int nota, alumno idAlumno, materia idMateria) {
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
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
        return "inscripcion{" + "idInscripto=" + idInscripto + ", nota=" + nota + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria + '}';
    }

}
