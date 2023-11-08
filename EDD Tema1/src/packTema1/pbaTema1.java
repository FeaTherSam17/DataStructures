/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packTema1;

import java.util.ArrayList;

/**
 *
 * @Uso del arreglo dinamico ArrayList
 */
public class pbaTema1 {
    public static void main(String[] args) {
        ArrayList <String> Lista = new ArrayList<>();
        ArrayList <String> Lista2 = new ArrayList<>();
        
        //Agregar datos 
        Lista.add("JUAN");
        Lista.add("ANGEL");
        // Mostrar contenido
        System.out.println("Contenido: "+Lista);
        // Agregar en posicion
        Lista.add(1, "Jhoni");
        //Se desplazan los elementos
        System.out.println("Contenido: "+Lista);
        
        //Conocer el tamaño o longitud
        System.out.println("Tamaño: "+Lista.size());
        //Conocer posición
        System.out.println("Posicion de Jhoni "+Lista.indexOf("Jhoni"));
        // Agregar una Lista a otra
        Lista2.addAll(Lista);
        System.out.println("Contenido Lista2: "+Lista2);
        //Eliminar un dato por dato
        Lista.remove("Jhoni");
        System.out.println("Eliminar");
        System.out.println("Contenido: "+Lista);
        //Posicion
        Lista.remove(0);
        System.out.println("Contenido: "+Lista);
        //Recorrido
        Lista.add("Patricio");
        Lista.add("ANA");
        Lista.add("ANDREA");
        Lista.add("ERIKA");
        Lista.add("ARMANDO");
        Lista.add("VALERIE");
        //Borrar contenido
        Lista2.clear();
        //Ejemplo
        for(String nombre : Lista){
            //System.out.println("Nombre "+ nombre);
            if(nombre.charAt(0)=='A'){
                Lista2.add(nombre);
            }
            
        }
        System.out.println("Contenido Lista 2: "+Lista2);
        //Asignar un dato
        Lista2.set(1, "ARIADNA");
        System.out.println("Contenido Lista 2: "+Lista2);
        //Regresa el contenido de una posicion
        System.out.println("En posicion 2: "+Lista2.get(2));
        //Determina si existe un dato
        if(Lista2.contains("ANA")){
            System.out.println("Si contiene a ANA");
        }else
            System.out.println("No la contiene");
        
        
        
        
        
        
    }
}