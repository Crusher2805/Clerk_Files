
package practicaprogramada1;


public class NumerosPares {
     public static void pares (int num) {
        if (num < 0) {
            return;
        }
        
        if (num % 2 != 0){
           n-=1; 
        }
        
        pares (num-2);
        System.out.print(n + "\n");
    }
}
