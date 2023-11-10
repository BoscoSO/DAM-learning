import java.util.HashSet;
class A{
    int a;
    HashSet<B> misB;
    A(int x){
        a=x;
        misB= new HashSet<>();
    }

    @Override
    public String toString() {
        String s="a" +a+ " se relaciona con ";
        for(B unb :misB){
            s+="b"+unb.b+" ";
        }
        return s;
    }
    
}

class B{
    int b;
    HashSet<A> misA;
    B(int x){
        b=x;
        misA= new HashSet<>();
    }
    public String toString() {
        String s="b" +b+ " se relaciona con ";
        for(A una :misA){
            s+="a"+una.a+" ";
        }
        return s;
    }
    
    
}

public class Unidad5{

    public static void main(String[] args) {
        A a1= new A(1);
        A a2= new A(2);
        B b1= new B(1);
        B b2= new B(2);
        a1.misB.add(b1); a1.misB.add(b2);
        a2.misB.add(b1); a2.misB.add(b2);
        b1.misA.add(a1); b1.misA.add(a2);
        b2.misA.add(a1); b2.misA.add(a2);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);
        
    }
    
}
