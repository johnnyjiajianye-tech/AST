/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicisteoria;

import static java.lang.Boolean.TRUE;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author johnny.jia.jian.ye
 */
public class GroupEx {
    // Atributos
    
    protected int n;
    protected ReentrantLock mon;
    protected Condition recursoLibre;
    protected boolean ocupado;
    
    
    //Metodos
    
    public GroupEx(int n){
        this.n = n;
        mon = new ReentrantLock();
        recursoLibre = mon.newCondition();
        
    }
    
    public void enter() throws InterruptedException{
        mon.lock();
        try {   
            while(ocupado || n>1){
                recursoLibre.await();   
            }
            ocupado = TRUE; 
            n = n-1;    // O n = 0;
        } finally {
            mon.unlock();
        }
        
        
    }
    
    public void exit(){
        
    }
}
