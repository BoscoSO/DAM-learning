package listaEnlazada;

class Contacto{
    String nombre;
    String telefono;
    Contacto(String nombre,String telefono){
        this.nombre=nombre;
        this.telefono=telefono;
    }
}
class Nodo{
  Nodo sig;
  Contacto dato;
  Nodo(Contacto dato, Nodo sig) {
    this.dato = dato;
    this.sig = sig;
  }
  public void setSiguiente(Nodo sig) {
    this.sig = sig;
  }
  public Nodo getSiguiente() {
    return sig;
  }
  public Contacto getDato() {
    return dato;
  }
}
class MiListaEnlazada{
    Nodo primero=null;
    void insertar(Contacto c){
        if (primero==null)
            primero=new Nodo(c,null);
        else
            primero=new Nodo(c,primero);
    }
    String getTelefono(String nombre){
        String telefonoResultado="Sin resultado";
        Nodo temp=primero;
        while(temp!=null){
            if(temp.dato.nombre.equals(nombre)){
                telefonoResultado=temp.dato.telefono;
                break;
            }
            temp=temp.getSiguiente();
        }
        return telefonoResultado;
    }
   
    public String toString(){
        String s="";
        Nodo temp=primero;
        while(temp!=null){
            s+=temp.dato.nombre+","+temp.dato.telefono+" | ";
            temp=temp.getSiguiente();
        }
        return s;
    }
}

class MiTablaHash{
    MiListaEnlazada[] tabla={new MiListaEnlazada(),new MiListaEnlazada(),new MiListaEnlazada(),new MiListaEnlazada(),new MiListaEnlazada()};
    
    int convertirNombreEnNumeroDeLista(String nombre){
        //calculamos listaEnlazada que le corresponde con funcion hash
        int sumaCaracteres=0;
        for(int i=0;i<nombre.length();i++){
            sumaCaracteres+=nombre.charAt(i);
        }
        return sumaCaracteres%5;
    }
    void insertar(String nombre, String telefono){
        
        int numeroDeLista=convertirNombreEnNumeroDeLista(nombre);
        tabla[numeroDeLista].insertar(new Contacto(nombre,telefono));
    }
    String getTelefono(String nombre){
        int numeroDeLista=convertirNombreEnNumeroDeLista(nombre);
        return tabla[numeroDeLista].getTelefono(nombre);
    }
    void imprimirEstructuraTabla(){
        for(int i=0;i<tabla.length;i++){
            System.out.print("Lista enlazada de entrada "+i+" :");
            System.out.print(tabla[i].toString());
            System.out.println();
        }
    }
    
}

class Unidad6{
    public static void main(String[] args) {
        MiTablaHash mth= new MiTablaHash();
        mth.insertar("chuli1", "111");mth.insertar("chuli2", "222");mth.insertar("chuli3", "333");
        mth.insertar("chuli4", "444");mth.insertar("chuli5", "555");mth.insertar("chuli6", "666");
        mth.insertar("chuli7", "777");mth.insertar("chuli8", "888");mth.insertar("chuli9", "999");
        
        System.out.println("Teléfono de chuli9: "+mth.getTelefono("chuli9"));
        System.out.println("Teléfono de pachuli: "+mth.getTelefono("pachuli"));
        
         System.out.println("Estructura de la tabla");
         mth.imprimirEstructuraTabla();
        
    }
}
