/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan08042023;

/**
 *
 * @author HP
 */
public class LatModul11_1 extends StudentRecord{
    
    public LatModul11_1(){
        super( "gina", "balai selasa"); 
    }
    
    public static void main( String[] args ){  
        LatModul11_1 gina = new LatModul11_1();
        System.out.println("Nama    :" + gina.name);
        System.out.println("Alamat  :" + gina.address);
        
        System.out.println("Count= "+StudentRecord.getStudentCount());
    }
    
    @Override
    public String getName(){
        System.out.println("gina adalah student");
        return name;
    }
}
