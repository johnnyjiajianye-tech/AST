/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicismontard25;

import static java.lang.Math.random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnny.jia.jian.ye
 */
public class Runner extends Thread { // no puedo compilar este codigo en el PC del lab del A2 por la version del JDK
    protected String id;
    
    public Runner(String nom){
        id = nom;
    }
    
    public void correr() throws InterruptedException{ 
        for(int i=1;i<=100;i++){
            sleep((long) random()); // sino pongo el long dice que hay missmatch the variables
            System.out.println("Corredor"+id+"ha recorregut"+i+"metres");
        }
        System.out.println("Corredor"+id+"ha arribat");
    }
    @Override
    public void run() {
        try {
            correr();
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex); // ni idea de lo que hace esta linea de codigo
        }
       
    }
    public static void main(String[] args) throws InterruptedException{
        Runner c1 = new Runner("C1");
        Runner c2 = new Runner("C2");
        c1.start();
        c2.start();
        c1.join();
        c2.join();
        System.out.println("Cursa ACABADA");
    }
    
    
    
    
    
}
