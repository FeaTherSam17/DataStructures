/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionsPack;

/**
 *
 * @author Alumno
 */
public class ExceptionFormatoInvalido extends Exception
{
    public ExceptionFormatoInvalido(){
        
    }
    
    public ExceptionFormatoInvalido(String mensaje){
        super(mensaje);
    }
}
