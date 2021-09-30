package AsignacionGrupos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AsignacionGrupos {
    static int group=0;
    static ArrayList<Alumno> students=new ArrayList<>();
    static ArrayList<Grupo> groups=new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        int option=7;
        while(option!=0) {
            System.out.print("""
                    ********MENU********
                    1.Añadir Alumnos
                    2.Generar Grupos
                    3.Visualizar Alumnos
                    4.Visualizar Grupos
                    5.Visualizar Alumnos
                    sin grupo
                    6.Eliminar Alumno
                    7.Eliminar Grupo
                    0.Salir
                    Opcion:\s""");
            option = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (option) {
                case 1 -> {
                    try{
                        addStudent();
                    }catch (InputMismatchException ex){
                        System.out.println("Ha introducido un tipo de dato erroneo");
                    }
                }
                case 2 -> {try{
                    generateGroups();
                }catch (InputMismatchException ex){
                    System.out.println("Ha introducido un tipo de dato erroneo");
                }}
                case 3-> viewStudents();
                case 4 -> viewGroups();
                case 5 -> viewStudentsWithoutGroup();
                case 6 -> {try{
                    removeStudent();
                }catch (InputMismatchException ex){
                    System.out.println("Ha introducido un tipo de dato erroneo");
                }}
                case 7 -> {try{
                    removeGroup();
                }catch (InputMismatchException ex){
                    System.out.println("Ha introducido un tipo de dato erroneo");
                }}
                default -> System.out.println("Introduce una opcion valida");
            }
        }
        System.out.println("Hasta la proxima");
    }
    public static void addStudent() throws InputMismatchException {
        String name;
        int age,telefone,option=1,howManyStudents,id;
        System.out.print("Cuantos estudiantes desea generar?\nNumero de alumnos: ");
        howManyStudents=Integer.parseInt(new Scanner(System.in).nextLine());
        for (int i=0;i<howManyStudents;i++) {
            System.out.print("Introduzca el ID del alumno\nID del alumno:");
            id=Integer.parseInt(new Scanner(System.in).nextLine());
            while(verifyId(id)){
                System.out.print("El ID del alumno ya existe, escriba un ID diferente\nID del alumno:");
                id=Integer.parseInt(new Scanner(System.in).nextLine());
            }
            System.out.print("Introudce el nombre del alumno\nNombre alumno: ");
            name = new Scanner(System.in).nextLine();
            while (checkName(name)) {
                System.out.print("Introudce un nombre de alumno que no este registrado\nNombre alumno: ");
                name = new Scanner(System.in).nextLine();
            }
            System.out.print("Introudce la edad del alumno\nEdad alumno: ");
            age = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.print("Introudce el telefono del alumno\nTelefono alumno: ");
            telefone = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.printf("%s%n" + "%d%n" + "%d%n" + "%s%n"+"%s", name, age, telefone, "Es correcto?", "Respuesta: ");
            if (new Scanner(System.in).nextLine().equalsIgnoreCase("Si")) {
                students.add(new Alumno(id,name, age, telefone));
            }else{
                System.out.print("Volver a introducir los datos\nRespuesta: ");
                if(new Scanner(System.in).nextLine().equalsIgnoreCase("No")){
                    return;
                }else{
                    i--;
                }
            }
        }
    }
    public static boolean verifyId(int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                return true;
            }
        }
        for(int i=0;i<groups.size();i++){
            for(int j=0;j<groups.get(i).getAlumnos().size();j++){
                if(groups.get(i).getAlumnos().get(j).getId()==id){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkName(String name) {
        if(!studentsIsEmpty()){
            for(int i=0; i<students.size();i++){
                if(name.equalsIgnoreCase(students.get(i).getName())){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static void generateGroups() throws InputMismatchException{
        int number;
        float divider,howManyGroups;
        String groupName;
        ArrayList<Alumno> studentsOfGroup;
        if(studentsIsEmpty()){
            System.out.println("No hay alumnos");
            return;
        }
        System.out.print("Cuantos grupos deseas generar?\nNumero de grupos:");
        howManyGroups=Integer.parseInt(new Scanner(System.in).nextLine());
        while(howManyGroups>students.size()){
            System.out.print("No pueden haber mas grupos que alumnos"
                    +", vuelva a introducir el numero de grupos\nNumero de grupos");
        }
        divider=Math.round(students.size()/howManyGroups);
        for(int i=0; i<howManyGroups;i++){
            System.out.print("Introduce el numero del grupo\nNumero: ");
            number=Integer.parseInt(new Scanner(System.in).nextLine());
            while(checkGroupNumber(number)){
                System.out.print("El numero de grupo ya existe,introduce un numero distinto\nNumero: ");
            }
            System.out.print("Introduce el nombre del grupo\nNombre del grupo: ");
            groupName=new Scanner(System.in).nextLine();
            studentsOfGroup=new ArrayList<>();
            for(int j=0;j<divider;j++){
                if(students.size()>0) {
                    int wildcard = new Random().nextInt((students.size() - 1) + 1);
                    studentsOfGroup.add(students.get(wildcard));
                    students.remove(wildcard);
                }
            }
            System.out.printf("%d\t"+"%s\t",number,groupName);
            for (int j=0;j<studentsOfGroup.size();j++){
                System.out.print(studentsOfGroup.get(j).getName()+"\t");
            }
            System.out.print("\nEs correcto?: ");
            if (new Scanner(System.in).nextLine().equalsIgnoreCase("Si")) {
                groups.add(new Grupo(number,groupName,studentsOfGroup));
                for(int j=0;j<studentsOfGroup.size();j++){
                    studentsOfGroup.get(j).setGroup(groups.get(group));
                }
            }else{
                for(int j=studentsOfGroup.size();j>0;j++){
                    students.add(studentsOfGroup.get(j-1));
                    studentsOfGroup.remove(j-1);
                }
                System.out.print("Volver a introducir los datos\nRespuesta: ");
                if(new Scanner(System.in).nextLine().equalsIgnoreCase("No")){
                    return;
                }else {
                    i--;
                }
            }
        }
        group++;
    }
    public static boolean checkGroupNumber(int number){
        for(int i=0;i<groups.size();i++){
            if(groups.get(i).getNumero()==number){
                return true;
            }
        }
        return false;
    }
    public static void viewStudents(){
        if(groupsIsEmpty()){
            System.out.println("No hay grupos, con lo cual no hay alumnos con grupos");
            return;
        }
        for(int i=0;i<groups.size();i++){
            for(int j=0;j<groups.get(i).getAlumnos().size();j++){
                System.out.printf("%d\t"+"%s\t"+"%d\t"+"%d\t"+"%s\n"
                        ,groups.get(i).getAlumnos().get(j).getId()
                        ,groups.get(i).getAlumnos().get(j).getName()
                        ,groups.get(i).getAlumnos().get(j).getAge()
                        ,groups.get(i).getAlumnos().get(j).getTelefone(),groups.get(i).getNombreGrupo());
            }
        }
    }
    public static void viewGroups(){
        if(groupsIsEmpty()){
            System.out.println("No hay grupos");
            return;
        }
        for(int i=0;i<groups.size();i++){
            System.out.printf("%d\t"+"%s\n",groups.get(i).getNumero(),groups.get(i).getNombreGrupo());
        }
    }
    public static void viewStudentsWithoutGroup(){
        if(studentsIsEmpty()){
            System.out.println("No hay alumnos sin grupo");
            return;
        }
        for(int i=0;i<students.size();i++){
            System.out.printf("%d\t"+"%s\t"+"%d\t"+"%d\n",students.get(i).getId(),students.get(i).getName(),students.get(i).getAge(),students.get(i).getTelefone());
        }
    }
    public static void removeStudent() throws InputMismatchException{
        if(studentsIsEmpty()){
            System.out.println("No hay alumnos");
            return;
        }
        int id;
        viewStudents();
        viewStudentsWithoutGroup();
        System.out.print("Escriba el ID del alumno\nID del alumno:");
        id=Integer.parseInt(new Scanner(System.in).nextLine());
        for(int i=0;i<groups.size();i++){
            for(int j=0;j<groups.get(i).getAlumnos().size();j++){
                if(groups.get(i).getAlumnos().get(j).getId()==id){
                    groups.get(i).getAlumnos().remove(j);
                    return;
                }
            }
        }
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return;
            }
        }
    }
    public static void removeGroup() throws InputMismatchException{
        if(groupsIsEmpty()){
            System.out.println("No hay grupos");
            return;
        }
        viewGroups();
        int number;
        System.out.print("Introduce el numero del grupo\nNumero del grupo:");
        number=Integer.parseInt(new Scanner(System.in).nextLine());
        for(int i=0;i<groups.size();i++){
            if(groups.get(i).getNumero()==number){
                students.addAll(groups.get(i).getAlumnos());
                groups.remove(i);
            }
        }
    }
    public static boolean studentsIsEmpty(){
        return students.isEmpty();
    }
    public static boolean groupsIsEmpty(){
        return groups.isEmpty();
    }
}