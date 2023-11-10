package practica2;

/**
 * Clase donde reside el método main() que inicia la aplicación
 */
public class ProgramaFilosofos implements IProgramaFilosofos{

    //////////////////////////// ATRIBUTOS /////////////////////////////////////
    


    //////////////////////////// SETTERS Y GETTERS /////////////////////////////
    public IFilosofo[] getFilosofos() {
        //TODO:
        return null;
    }

    public int getNumeroFilosofos() {
        //TODO:
        return 0;
    }

    public void setNumeroFilosofos(int numeroFilosofos) {
        //TODO:
    }

    //////////////////////////// CONSTRUCCION //////////////////////////////////
    
    ProgramaFilosofos(){
        this.setNumeroFilosofos(5);
    }
    ProgramaFilosofos(String[] args){
        this.procesaParametros(args);
        this.construyeEscenario();
    }

    //////////////////////////// COMPORTAMIENTO ////////////////////////////////
    private void procesaParametros(String[] args){
        //TODO:
    }

    private void construyeEscenario() {
        MesaRedonda mesa=new MesaRedonda();
        Object[] params=new Object[] {0,3l,1000l,1500l,mesa};
        Thread t1=new Thread(new Filosofo("filosofo0", params));
        params=new Object[] {1,1l,1000l,1500l,mesa};
        Thread t2=new Thread(new Filosofo("filosofo1", params));
        params=new Object[] {2,2l,1000l,2500l,mesa};
        Thread t3=new Thread(new Filosofo("filosofo2", params));
        params=new Object[] {3,2l,1000l,1500l,mesa};
        Thread t4=new Thread(new Filosofo("filosofo3", params));
        params=new Object[] {4,1l,1500l,1500l,mesa};
        Thread t5=new Thread(new Filosofo("filosofo4", params));
        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public void comenzar(){
        //TODO:
    }

    //////////////////////////// ARRANQUE //////////////////////////////////////
    public static void main(String[] args) {

        if(args.length==0){
            // Valores por defecto
            args = new String[1];
            args[0] = String.valueOf(5); // Número de filósofos
        }

        new ProgramaFilosofos(args).comenzar();;
    }
}
