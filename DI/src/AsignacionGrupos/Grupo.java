package AsignacionGrupos;

import java.util.ArrayList;

public class Grupo {
    private int number;
    private String groupName;
    private ArrayList<Alumno> students;
    Grupo(int number,String groupName,ArrayList<Alumno>students) {
        this.number = number;
        this.groupName = groupName;
        this.students= students;
    }

    public int getNumero() {
        return number;
    }

    public void setNumero(int number) {
        this.number = number;
    }

    public String getNombreGrupo() {
        return groupName;
    }

    public void setNombreGrupo(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Alumno> getAlumnos() {
        return students;
    }

    public void setAlumnos(ArrayList<Alumno> students) {
        this.students = students;
    }
}
