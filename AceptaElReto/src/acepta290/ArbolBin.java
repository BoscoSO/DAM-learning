package acepta290;

class ArbolBin {

    public NodoArbol raiz;
    char[] arbolChar;//el arbol como una línea de texto
    int posArray=0;

    public ArbolBin(String linea) {
        raiz = null;
        this.arbolChar=linea.toCharArray();
        if(this.arbolChar.length>500){
            this.arbolChar=null;
        }   
    }


    public int alturaHijo(NodoArbol a) {
    	int x=1,y=1;
    	if (a!=null){
    	
            if(a.nodoDer!=null) {
    			x+=alturaHijo(a.nodoDer);
    		}
    		if(a.nodoIzq!=null)
    			y+=alturaHijo(a.nodoIzq);
    		
    		if(x>y)
                return x;
            return y;    
        }
		return 0;
    }

    public void crearArbol() {
        //la raiz está en arbolChar[0]        
        char dato=arbolChar[0];
       
        if (dato == '.') {//arbol vacío
            raiz = null;

        } else {
            raiz = new NodoArbol(dato);
            posArray++;
            
            crearSubArbolIzquierdo(raiz);
            crearSubArbolDerecho(raiz);

        }
    }

     
    private void crearSubArbolIzquierdo(NodoArbol padre) {
        //crear un subarbol es crear su raiz y recursivamente sus hijos
       //la recursividad para  si el dato es -1
        
        char dato=arbolChar[posArray];
        posArray++;
        if (dato != '.') {
            //creamos un nuevo nodo
            padre.nodoIzq= new NodoArbol(dato);
            crearSubArbolIzquierdo(padre.nodoIzq);
            crearSubArbolDerecho(padre.nodoIzq);
        }
        
    }
    
    private void crearSubArbolDerecho(NodoArbol padre) {
        //crear un subarbol es crear su raiz y recursivamente sus hijos
       //la recursividad para  si el dato es -1
    	char dato=arbolChar[posArray];
        posArray++;
        if (dato != '.') {
            //creamos un nuevo nodo derecho
            padre.nodoDer= new NodoArbol(dato);
            crearSubArbolIzquierdo(padre.nodoDer);
            crearSubArbolDerecho(padre.nodoDer);
            
        }

    }
 
}