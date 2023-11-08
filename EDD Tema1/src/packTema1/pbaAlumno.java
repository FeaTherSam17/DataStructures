/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packTema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Polly
 */
public class pbaAlumno {

    public static void main(String[] args) throws IOException {
        int opcion = 0;
        
        //Scanner leer = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Alumno> Lista = new ArrayList<>();
        //Almacena direccion- referencia
        String nombre;
        float calif;

        do {
            System.out.println("-------------------");
            System.out.println("MENU DE ALUMNOS");
            System.out.println("1. Agregar en orden");
            System.out.println("2. DAR DE BAJA ");
            System.out.println("3. DESPLEGAR ");
            System.out.println("4. Modificar");//lista
            System.out.println("9. SALIR");

            opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 1:
                    boolean bandera = false;
                    
                    System.out.println("Nombre");
                    nombre = br.readLine().toUpperCase();
                    System.out.println("Calificacion");
                    calif = Float.parseFloat(br.readLine());
                    Alumno alum = new Alumno(nombre, calif);

                    //Se van ordenando
                    if (Lista.isEmpty()) { // Caso 1 con lista vacia
                        Lista.add(alum);
                    } else {
                        for (Alumno obj : Lista) {
                            if (nombre.compareToIgnoreCase(obj.getNombre()) <= 0) {
                                Lista.add(Lista.indexOf(obj), alum);
                                bandera=true;
                                break;
                            }
                        }
                        if (!bandera) {
                            Lista.add(alum);
                        }
                    }

                    break;

                case 2:
                    int indice = -1;
                    System.out.println("Que alumno desea dar de baja:");
                    System.out.println("Ingrese el Nombre: ");
                    nombre = br.readLine().toUpperCase();
                    int tam = Lista.size();
                    for (Alumno AL : Lista) {//Recorre el arreglo for-each

                        if (AL.getNombre().equals(nombre)) {//Se colaliza el nombre del objeto
                            System.out.println("Alumno: " + AL.getNombre() + " Eliminado");
                            Lista.remove(AL);
                            break;
                        }
                        //break;
                    }
                    if (tam == Lista.size()) {
                        System.out.println("Alumno no encontrado");
                    }
                    break;

                case 3:
                    for (Alumno al : Lista) {
                        System.out.println("Nombre: " + al.getNombre() + " Calificacion: " + al.getCalif());
                    }

                    break;
                case 4:
                    System.out.println("Ingrese el nombre del alumno a modificar: ");
                    nombre = br.readLine().toUpperCase();
                    for (Alumno AlM : Lista) {
                        if (AlM.getNombre().equals(nombre)) {
                            indice = Lista.indexOf(AlM);
                            System.out.println("Ingrese el Nuevo nombre");
                            nombre = br.readLine().toUpperCase();
                            System.out.println("Ingrese la calificacion");
                            calif = Float.parseFloat(br.readLine());
                            Alumno Nuevo = new Alumno(nombre, calif);
                            Lista.add(indice, Nuevo);
                            break;

                        }
                    }

                    break;
            }

        } while (opcion != 9);

    }

}
