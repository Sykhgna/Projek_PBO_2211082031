/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina16032023;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class latihan2 {
    public static void main(String[] args){
    BufferedReader dataIn = new BufferedReader (new InputStreamReader(System.in));
    String kata1, kata2, kata3;
    Scanner sc = new Scanner(System.in);
    
    

        // Meminta pengguna memasukkan tiga kata
        try{
        System.out.println("Masukkan kata pertama:");
        kata1 = sc.nextLine();
        System.out.println("Masukkan kata kedua:");
        kata2 = sc.nextLine();
        System.out.println("Masukkan kata ketiga`:");
        kata3 = sc.nextLine();

        // Menampilkan output ke layar
        System.out.println("Anda memasukkan kata-kata berikut:");
        System.out.print(kata1+" ");
        System.out.print(kata2+" ");
        System.out.print(kata3+" ");
        } catch (Exception ex) {
        }
    }
}
