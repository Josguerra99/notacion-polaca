
package notacion_polaca;



public class Lista 
{
   private Nodo primerNodo;
   private Nodo ultimoNodo;
   private Nodo actualNodo;
   private String nombre; 

  
   public Lista() 
   { 
      this( "lista" ); 
   } 

   
   public Lista( String nombreLista )
   {
      nombre = nombreLista;
      primerNodo = ultimoNodo = null;
   } 
   public void insertarAlFrente( char elementoInsertar )
   {
      if ( estaVacia() ) 
         primerNodo = ultimoNodo = new Nodo( elementoInsertar );
      else 
         primerNodo = new Nodo( elementoInsertar, primerNodo );
   } 

   
   public void insertarAlFinal( char elementoInsertar )
   {
      if ( estaVacia() ) 
         primerNodo = ultimoNodo = new Nodo( elementoInsertar );
      else 
         ultimoNodo = ultimoNodo.siguienteNodo = new Nodo( elementoInsertar );
   } 

   
   public Object eliminarDelFrente() throws ExcepcionListaVacia
   {
      if ( estaVacia() ) 
         throw new ExcepcionListaVacia( nombre );

      Object elementoEliminado = primerNodo; 

   
      if ( primerNodo == ultimoNodo )
         primerNodo = ultimoNodo = null;
      else
         primerNodo = primerNodo.siguienteNodo;

      return elementoEliminado;
   } 


   public Object eliminarDelFinal() throws ExcepcionListaVacia
   {
      if ( estaVacia() ) 
         throw new ExcepcionListaVacia( nombre );

      Object elementoEliminado = ultimoNodo.datos; 

    
      if ( primerNodo == ultimoNodo )
         primerNodo = ultimoNodo = null;
      else 
      { 
         Nodo actual = primerNodo;

         while ( actual.siguienteNodo != ultimoNodo )
            actual = actual.siguienteNodo;
   
         ultimoNodo = actual; 
         actual.siguienteNodo = null;
      } 

      return elementoEliminado; 
   } 
   
   public int cantidadNodos() {
        int can = 0; /* empezamos con cantidad igual a 0  */
        Nodo aux = primerNodo; /* decimos que el auxiliar es igual a cabeza osea posicion1  */
        while (aux != null) { /* ciclo hasta que el auxiliar sea nulo  */
            can++; /* aumente la cantidad  */
            aux = aux.siguienteNodo; /* y el auxiliar sea de siguiente en siguiente  */
        }/* cantidad lo que hace es contar el numero de veces que auxiliar se mueve  */
      //  System.out.println("cant " + can);
        return can; /*  retorna el valor de cantidad */

    }
   
   public Nodo getActual(){
       return actualNodo;
   }
   
   public boolean ultimo(){
       actualNodo = ultimoNodo;
       return true;
   }
   
   public boolean first(){
       actualNodo = primerNodo;
       return true;
   }
   
   public boolean anterior() {
       Nodo antNodo = primerNodo;
        if (ultimoNodo == null) {
            return false;
        }
        if(actualNodo == primerNodo){
            return false;
        }
        if (actualNodo == null) {
            actualNodo = ultimoNodo;
            return true;
        } else {
            while (antNodo.siguienteNodo != actualNodo) {  
                /*asignele a aux siguiente ciclo hasta que sea nulo*/
                antNodo = antNodo.siguienteNodo;  /*le da a aux el siguiente*/
            }
            actualNodo = antNodo;
            return true;
        }
    }
   
   public boolean next() {
        if (primerNodo == null) {
            return false;
        }
        if (actualNodo == null) {
            actualNodo = primerNodo;
            return true;
        } else {
            if (actualNodo.siguienteNodo != null) {
                actualNodo = actualNodo.siguienteNodo;
                return true;
            } else {
                return false;
            }
        }
    }
   

  
   public boolean estaVacia()
   { 
      return primerNodo == null; 
   }
   
   public Object parteSuperiorPila() //devuelve el valor de la parte superior de la pila sin sacarlo
   {
       Object valor = ultimoNodo.datos;
       return valor;
   }
   
   public void imprimir()
   {
      if ( estaVacia() ) 
      {
         System.out.printf( "%s vacia\n", nombre );
         return;
      }

      System.out.printf( "La %s es: ", nombre );
      Nodo actual = primerNodo;

   
      while ( actual != null ) 
      {
         System.out.printf( "%s ", actual.datos );
         actual = actual.siguienteNodo;
      } 

      System.out.println( "\n" );
   } 
}
