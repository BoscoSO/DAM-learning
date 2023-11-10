package practica2;

public class FactoryFilosofo{
    private static final FactoryFilosofo INSTANCE = new FactoryFilosofo();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    private FactoryFilosofo() {}

    public static FactoryFilosofo getInstance() {
        return INSTANCE;
    }

    /**
     * constructor de tres parámetros, cada uno de los cuales se guardará en una
     * variable local para usarla cuando sea neceario
     *
     * @param miIndice: índice que identifica al filósofo (un entero del 0 al 4)
     * @param semaforoPalillo: vector de semáforos (uno para cada palillo).
     * @param palillosFilosofo: matriz que para cada valor de su primer
     * índice, la fila, almacena los palillos que necesita el filósofo de ese
     * índice para comer. Por ejemplo: el filósofo de índice 0 necesita los
     * palillos de índices {0,4}, el de índice 1 los de índices {1,0}, etc...
     * Puedes prescindir de este vector si se te ocurre como calcular en tiempo
     * real los índices de los palillos que necesita cada filósofo para comer
     */
    public IFilosofo construirFilosofo(String pNombreFilosofo, Object... params){
        IFilosofo newFilosofo = new Filosofo(pNombreFilosofo, params);
        return newFilosofo; 
    }

    /** Construye un programa filósofos con parámetros por defecto */
    public IProgramaFilosofos contruirProgramaFilosofos(){
        return new ProgramaFilosofos();
    }

    /** Construye un programa filósofos con parámetros por línea de consola */
    public IProgramaFilosofos contruirProgramaFilosofos(String[] args){
        return new ProgramaFilosofos(args);
    }


}