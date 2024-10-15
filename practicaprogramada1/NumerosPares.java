/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada1;

/**
 *
 * @author sebas
 */
public class NumerosPares {
     public static void pares (int n) {
        if (n < 0) {
            return;
        }
        
        if (n % 2 != 0){
           n-=1; 
        }
        
        pares (n-2);
        System.out.print(n + "\n");
    }
}
