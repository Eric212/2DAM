package AsignacionGrupos;

public class Alumno {
    private String name;
    private int age,telefone,id;
    private Grupo group;
    Alumno(int id,String name, int age,int telefone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.telefone = telefone;
        this.group = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grupo getGroup() {
        return group;
    }

    public void setGroup(Grupo group) {
        this.group = group;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
