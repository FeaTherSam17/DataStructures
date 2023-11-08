/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbaEstructuras;

//6import exceptionsPack.ExcepcionPers;
import exceptionsPack.ExcepcionPers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import listasPack.ListaDoble;
import listasPack.ListaSimple;
import listasPack.Nodo;
import listasPack.NodoDoble;
import pilasPack.Cola;
import pilasPack.Pila;
import listasPack.ListaDobleCircular;

/**
 *
 * @author Alumno
 */
public class pbaLineales {

    public static Object elimina(String materia, Pila objPila) {
        Object dato = null;
        Pila objPila2 = new Pila(5);

        while (!objPila.empty() && !materia.equals(objPila.stackTop())) {//CICLO PARA METER LAS MATERIAS QUE NO SON LA REQUERIDA EN OTRA PILA
            //dato=objPila.pop();
            objPila2.push(objPila.pop());
        }

        if (!objPila.empty()) {
            dato = objPila.pop();
            //System.out.println("Popea XD");
        }

        while (!objPila2.empty()) {
            objPila.push(objPila2.pop());
        }
        //System.out.println(dato);
        return dato;
    }

    public static void vaciar(Pila objPila) {
        // Pila objAux = new Pila(5);

        while (!objPila.empty()) {
            objPila.pop();
        }

    }

    //METODO DEL EQUILIBRIO FUNCIONAL
    public static boolean equilibrio2(String cadena) {
        int n = 0;
        //Object dato;
        Pila pilaParentesis = new Pila(cadena.length());

        while (n < cadena.length()) {

            if (cadena.charAt(n) == '(') {
                pilaParentesis.push(cadena.charAt(n));
                //System.out.println("veces");

            } else if (cadena.charAt(n) == ')') {

                if (!pilaParentesis.empty()) {
                    pilaParentesis.pop();
                    //System.out.println("Popeo XD");
                } else {
                    return false;
                }

            }
            n++;

        }

        return pilaParentesis.empty();

    }

    //METODOS PARA LA PRUEBA DE COLAS
    //LLENADO DE COLA
    public static void llenarCola(Cola obCola) throws IOException {
        //SE PUEDE PASAR EL BUFFEREDREADER COMO PARAMETRO PARA NO CREAR OTRO OBJETO
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        String dato;

        while (!obCola.full()) {
            System.out.println("colo " + !obCola.full());
            System.out.println("Ingrese la palabra");

            dato = BR.readLine();
            obCola.insertQ(dato.toUpperCase());
        }

    }

    //COMBINAR 2 COLAS ALTERNADAMENTE
    public static void combinar(Cola objCola1, Cola objCola2, Cola obColaCombinada) {
        //System.out.println("hola");
        while (!obColaCombinada.full()) {
            if (!objCola1.empty()) {
                obColaCombinada.insertQ(objCola1.removeQ());
                //System.out.println("cola1");
                if (!objCola2.empty()) {
                    obColaCombinada.insertQ(objCola2.removeQ());
                    //System.out.println("cola2");
                }
            } else {
                if (!objCola2.empty()) {
                    obColaCombinada.insertQ(objCola2.removeQ());
                    //System.out.println("g");
                    if (!objCola1.empty()) {
                        obColaCombinada.insertQ(objCola1.removeQ());
                    }

                }

            }

        }

    }
    //UNIR 2 COLAS
    public static void union(Cola obCola1, Cola obCola2, Cola obCola3) {
        String dato1 = null;
        String dato2 = null;
        //SE SACAN LOS 2 DATOS
        if (!obCola1.empty()) {
            dato1 = (String) obCola1.removeQ();
            if (!obCola2.empty()) {
                dato2 = (String) obCola2.removeQ();

            }
        }
        //ENTRA AL CICLO QUE DIVIDE LAS LETRAS
        while (!obCola3.full()) {

            if (dato1.compareTo(dato2) < 0) {
                obCola3.insertQ(dato1);
                if (!obCola1.empty()) {
                    dato1 = (String) obCola1.removeQ();

                } else {
                    obCola3.insertQ(dato2);
                    while (!obCola2.empty()) {
                        obCola3.insertQ((String) obCola2.removeQ());

                    }
                }
            } else {
                obCola3.insertQ(dato2);
                if (!obCola2.empty()) {
                    dato2 = (String) obCola2.removeQ();
                } else {
                    obCola3.insertQ(dato1);
                    while (!obCola1.empty()) {
                        obCola3.insertQ((String) obCola1.removeQ());

                    }
                }
            }

        }
    }
    //INSERTA UN ELEMENTO A LA LISTA
    public static void insertarLista(ListaSimple Lista, BufferedReader br) throws IOException {

        String nombre;
        Nodo obNodo;
        System.out.println("");
        do {
            System.out.println("Ingrese los nombres a agregar en la lista");
            System.out.println("Salida = 0");
            nombre = br.readLine().toUpperCase();
            if (!nombre.equals("0")) {
                obNodo = new Nodo(nombre); //AZU P74K814
                Lista.insert(obNodo);

                System.out.println();
            }

        } while (!nombre.equals("0"));

    }
    //DESPLIEGA LA LISTA
    public static void desplegarLista(ListaSimple ob) {
        Nodo aux = ob.getInicial();
        
        if (ob.empty()) {
            System.out.println("Lista vacia");
        }else{
            System.out.println(ob.getInicial().getInfo()+"");
            while (aux.getSig() != null) {

            System.out.println(aux.getSig().getInfo() + " ");
            aux = aux.getSig();

        }
        }
        
    }
    // IDENTIFICA CUANTOS NOMBRES EMPIEZAN CON UNA LETRA
    public static int nombresConUnaLetra(ListaDoble ListaD,String letra){
        NodoDoble aux = ListaD.getFrente();
        int contador = 0;        
        while(aux.getSig()!=null){
            
            if(aux.getInfo().toString().substring(0,1).equals(letra) ){
                
                contador++;
                System.out.println(contador);
                aux=aux.getSig();
                
            }else{
                aux=aux.getSig();
            }

        }
        
        if(aux.getInfo().toString().substring(0,1).equals(letra) ){                
                contador++;
                System.out.println(contador);
            }
        
        return contador;
        
    }

    //CLASE MAIN
    public static void main(String[] args) throws IOException, ExcepcionPers, Exception {
        int opcion = 0;
        Object dato = null;
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        String materia;
        Pila obPila = new Pila(5);
        ListaSimple Lista = new ListaSimple();
        ListaDoble ListaD = new ListaDoble();
        ListaDobleCircular ListaDC = new ListaDobleCircular();

        boolean bandera = true;

        do {
            do {
                System.out.println("MENU DE OPERACIONES");
                System.out.println("1. INGRESAR MATERIAS EN PILA");
                System.out.println("2. ELIMINAR MATERIAS EN PILA");
                System.out.println("3. VACIAR LA PILA DESPLEGANDO DATOS");
                System.out.println("4. COMPROBAR SI UNA EXPRESION CON PARENTESIS");
                System.out.println("5. UNIR 2 COLAS EN UNA SOLA DE MANERA ALTERNADA");
                System.out.println("6. UNIR 2 COLAS PREVIAMENTE ORDENADAS,"
                        + "EN UNA TERCERA RESPETANDO EL ORDEN");
                System.out.println("7. INSERTAR NOMBRES EN UNA LISTA");
                System.out.println("8. ELIMINAR UN NOMBRE DE LA LISTA");
                System.out.println("9. DESPLEGAR LISTA DE NOMBRES");
                System.out.println("10. Llenar lista doble");
                System.out.println("11. Desplegar lista Doble DESCENDENTEMENTE");
                System.out.println("12. Desplegar lista Doble ASCENDENTEMENTE");
                System.out.println("13. BUSQUEDA DE ELEMENTOS");
                System.out.println("14. ELIMINAR UN ELEMENTO");
                System.out.println("15. DESPLLEGAR CUANTOS NOMBRES INICIAN CON CIERTA LETRA");
                System.out.println("16. AGREGAR DATOS LISTA CIRCULAS");
                System.out.println("17. DESPLEGAR LISTA");
                System.out.println("18. ELIMINAR ELEMENTO DE LA LISTA DOBLE CIRCULAR");
                System.out.println("19. BUSQUEDA");
                System.out.println("");

                try {
                    opcion = Integer.parseInt(BR.readLine());
                    bandera = false;
                } catch (Exception e) {

                    bandera = true;
                    System.out.println("Error en la entrada");

                }
            } while (bandera == true);

            switch (opcion) {
                case 1:
                    if (!obPila.full()) {
                        do {
                            System.out.println("Ingrese la materia");
                            materia = BR.readLine();
                            try {
                                bandera = false;
                                obPila.push(materia);
                            } catch (Exception e) {
                                bandera = true;
                                System.out.println("Error de formato");

                            }
                        } while (bandera == true);
                    } else {
                        System.out.println("La pila esta llena");
                    }
                    break;

                case 2:
                    if (!obPila.empty()) {
                        System.out.println("Ingrese la materia a eliminar");
                        materia = BR.readLine();
                        dato = elimina(materia, obPila);

                        if (dato != null) {
                            System.out.println("El objeto eliminado es: " + dato);
                        } else {
                            System.out.println("Objeto no encontrado");
                        }

                    } else {
                        System.out.println("Pila vacia");
                    }

                    break;
                case 3:
                    System.out.println("Vaciar la pila");
                    if (!obPila.empty()) {

                        vaciar(obPila);
                        System.out.println("Vaciamiento de la pila completado ");
                        System.out.println(obPila.empty());
                    } else {
                        System.out.println("Pila vacia");
                    }

                    break;
                case 4:

                    System.out.println("Ingrese una expresion");
                    materia = BR.readLine();

                    if (equilibrio2(materia)) {
                        System.out.println("Es equilibrada");
                    } else {
                        System.out.println("No es equilibrada");
                    }

                    break;
                case 5:
                    int elementos1 = 0;
                    int elementos2 = 0;
                    do {

                        System.out.println("Cuantas palabras va a ingresar en la primera cola");
                        try {
                            elementos1 = Integer.parseInt(BR.readLine());
                            bandera = false;
                        } catch (Exception e) {

                            System.out.println("Error de formato");
                            bandera = true;
                        }
                    } while (bandera == true);

                    do {
                        System.out.println("Cuantas palabras va a ingresar en la segunda cola");
                        try {

                            elementos2 = Integer.parseInt(BR.readLine());
                            bandera = false;
                        } catch (Exception e) {

                            System.out.println("Formato invalido");
                            bandera = true;
                        }
                    } while (bandera == true);
                    Cola cola1 = new Cola(elementos1);
                    Cola cola2 = new Cola(elementos2);
                    Cola cola3 = new Cola(elementos1 + elementos2);

                    llenarCola(cola1);
                    llenarCola(cola2);
                    //System.out.println("Lleno cola 1"+cola1.full());
                    //System.out.println("Lleno cola 1"+cola2.full());
                    //Metodo para el llenado
                    //System.out.println("Como tash");
                    combinar(cola1, cola2, cola3);

                    //System.out.println(cola3.full());
                    System.out.println("Cola combinada");
                    for (int i = 0; i < elementos1 + elementos2; i++) {
                        System.out.print(cola3.removeQ() + " ");
                    }
                    System.out.println("");

                    break;

                case 6:
                    System.out.println("Cuantas palabras va a ingresar en la primera cola");
                    elementos1 = Integer.parseInt(BR.readLine());

                    System.out.println("Cuantas palabras va a ingresar en la segunda cola");

                    elementos2 = Integer.parseInt(BR.readLine());

                    cola1 = new Cola(elementos1);
                    cola2 = new Cola(elementos2);
                    cola3 = new Cola(elementos1 + elementos2);

                    llenarCola(cola1);
                    llenarCola(cola2);

                    union(cola1, cola2, cola3);

                    while (!cola3.empty()) {
                        System.out.print(cola3.removeQ() + " ");
                    }
                    System.out.println("");
                    break;

                case 7:
                    //Se crea un objeto de tipo LISTA
                    insertarLista(Lista, BR);
                    break;

                case 8:
                    if (!Lista.empty()) {
                        System.out.println("Nombre eliminado: " + Lista.remove().getInfo());//DEVUELVE UN NODO POR ESO SE PUEDE ACCEDER AL METODO getInfo
                    } else {
                        System.out.println("Lista vacia");
                    }

                    break;

                case 9:
                    desplegarLista(Lista);
                    break;
                    
                case 10:
                    
                    System.out.println("Ingresa una letra");
                    materia = BR.readLine().toUpperCase();
                    NodoDoble nodoCad = new NodoDoble(materia);                   
                    ListaD.insert(nodoCad);
                    
                    break;
                    
                case 11:
                    try{
                    ListaD.desplegarDescendente();
                    }catch(Exception E){
                        System.out.println("Lista vacia");
                    }
                    break;
                    
                case 12:
                    
                    
                    ListaD.desplegarAscendente();
                    
                    break;
                case 13:
                    System.out.println("Ingresa una letra");
                    materia = BR.readLine().toUpperCase();
                    if(ListaD.busquedaElemento(materia)==null){
                        System.out.println("Elemento no encontrado o lista vacia");
                    }else{
                        System.out.println("Busqueda: "+ ListaD.busquedaElemento(materia).getInfo().toString());
                    }
                    
                    break;
                case 14:
                    
                    System.out.println("Ingrea la palabra a eliminar");
                    materia = BR.readLine().toUpperCase();
                    NodoDoble aux = ListaD.delete(materia);
                    //System.out.println(aux);
                    if (aux==null) {
                        System.out.println("Elemento no encontrado");
                    }else{
                        System.out.println("Elemento eliminado: "+aux.getInfo().toString());
                    }
                    
                    break;
                    
                case 15:
                    System.out.println("Ingrese una letra");
                    materia = BR.readLine().toUpperCase();
                    
                    System.out.println("Hay exactamente: "+nombresConUnaLetra(ListaD,materia)+" nombres que empiecen con: "+materia);
                    
                    break;
                    
                case 16:
                    System.out.println("Ingresa una letra");
                    materia = BR.readLine().toUpperCase();
                    nodoCad = new NodoDoble(materia);   // nodoCad declarado en la ocio                
                    ListaDC.insert(nodoCad);
                    
                    
                    break;
                case 17:
                    ListaDC.despliegue();
                    break;
                case 18:
                    
                    System.out.println("Ingresa el nombre: ");                    
                    materia = BR.readLine().toUpperCase();  
                    NodoDoble nodoInfo = null;
                    try{
                    nodoInfo =  ListaDC.eliminar(materia);
                    }catch(Exception e){
                        System.out.println("Elemento no");
                    
                    if (nodoInfo != null) {
                        System.out.println(nodoInfo.getInfo().toString()+" eliminado");
                    }else{
                        System.out.println("Elemento no encontrado");
                    }
                    }
                   
                   
                    
                    
                    break;

                case 19:
                    System.out.println("Ingresa el nombre a buscar");
                    materia=BR.readLine().toUpperCase();
                    try{
                        
                        ListaDC.busqueda(materia);
                        System.out.println(ListaDC.busqueda(materia).getInfo().toString());
                    }catch(Exception e){
                        System.out.println("Elemento no encontrado");
                    }
                    
                    break;
            }
            

        } while (opcion != 0);

    }

}
