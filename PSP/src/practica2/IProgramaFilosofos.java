package practica2;

public interface IProgramaFilosofos {

    /** Comienzan los filósofos a actual*/
    public void comenzar();

    /** Retorna un array de filósofos */
    IFilosofo[] getFilosofos();

    /** Retorna el número de filósofos creados por el programa */
    public int getNumeroFilosofos();

    /** Establece antes de comentar la cena de los filósofos el número que participarán */
    public void setNumeroFilosofos(int numeroFilosofos);
}
