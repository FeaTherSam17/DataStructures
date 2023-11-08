/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasPack;

/**
 *
 * @author Polly
 */
public class pbaColas {
    
    public static void main(String[] args) {
        Colas obColas=new Colas(3);
        obColas.push(1);
        obColas.push(2);
        obColas.push(3);
        System.out.println(obColas.empty());
        System.out.println("Full "+obColas.full());
        obColas.pop();
        obColas.pop();
        obColas.pop();
        System.out.println("vacio");
        System.out.println(obColas.empty());
        System.out.println("Prueba 1 pasada");
        System.out.println("");
        
        
        obColas.push(1);
        obColas.push(2);
       
        System.out.println(obColas.empty());
        System.out.println("Full "+obColas.full());
        obColas.pop();
        obColas.push(7);
        System.out.println("");
        System.out.println(obColas.empty());
        System.out.println("Prueba 1 pasada");
        System.out.println("");
        
        
        
        
        
        
        
    }
}
