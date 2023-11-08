/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packTema1;

/**
 *
 * @author Polly
 */
public class Alumno {

    private String nombre;
    private float calif;

    public Alumno(String nombre, float calif) {
        this.calif = calif;
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalif() {
        return calif;
    }

    public void setCalif(float calif) {
        this.calif = calif;
    }
}
