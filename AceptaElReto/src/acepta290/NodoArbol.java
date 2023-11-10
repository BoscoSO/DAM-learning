package acepta290;


class NodoArbol {
    NodoArbol nodoIzq;
    char datos;
    NodoArbol nodoDer;

    public NodoArbol(char datosNodo) {
        datos = datosNodo;
        nodoIzq = nodoDer = null; //recien creado un nodo, no tiene hijos
    }
}