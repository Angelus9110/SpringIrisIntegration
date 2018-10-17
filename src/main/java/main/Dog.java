package main;

public class Dog {
    private String nombre;
    private Person dueño;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Person getDueño() {
        return dueño;
    }

    public void setDueño(Person dueño) {
        this.dueño = dueño;
    }
}
