package listaEnlazada;

//import pila.MiPila;
//import pila.Pila;

class Unidad5 {
    public static boolean parentesisBalanceados(String expresion){
       //utiliza una pila para resolver el problema
  //  	Pila mPila1= new MiPila();
    	char c;
    	boolean fallo=false;
    	for(int i=0;i<expresion.length();i++) {
        	c=expresion.charAt(i);	
    		
    		if(c=='(') {
    //			mPila1.push(c);
    		}
    		
    		if(c==')') {
    	//		if(mPila1.pop()==0)
    				fallo=true;
    		}
    	}
    	
    	
    	if(fallo) {} 
    		return false;
    //	return mPila1.esVacia();
    }
    public static void main(String[] args) {
        String expresion="((2+3)/(3*(8-2))";
        System.out.println(parentesisBalanceados(expresion));
        expresion="(4(";
        System.out.println(parentesisBalanceados(expresion));
        expresion="(4)";
        System.out.println(parentesisBalanceados(expresion));
        expresion="(2+3)/(3*(8-2))";
        System.out.println(parentesisBalanceados(expresion));
    }
}
