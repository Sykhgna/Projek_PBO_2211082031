/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan08042023;

/**
 *
 * @author HP
 */
public class Square extends Shape {
   private int sisi;
    
    public Square(String nama) {
        super(nama);
        sisi = 3;
    }

    public float getArea() {
        float luas;
        luas = sisi * sisi;
        return luas;
    }
}
 