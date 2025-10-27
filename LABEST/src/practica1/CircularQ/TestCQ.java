package practica1.CircularQ;

import java.util.Arrays;

public class TestCQ {

  public static void main(String[] args) {
    CircularQueue<Integer> q = new CircularQueue<>(5);
    // throw new RuntimeException("//Completar...");
    int i = 1;
    
    //comprobar que no esta no llena ni vacia la cola sobretodo comprobar el funcionamiento de GET() y PUT()
    
    q.put(i);
   
    System.out.println("Queue con algun elemento"+q.toString());
     
    if(q.peekFirst()!=null){
        System.out.println("El método q.peekfirst() funciona correctamente"); 
    }

    if(q.free()>0){
        System.out.println("El método q.free() funciona correctamente");
    }
    
    if(q.size()>0){
        System.out.println("El método q.size() funciona correctamente");
    }
    
    q.peekFirst();
    q.get();
    
    // En teoria la cola esta vacia si funciona bien el get() y set()
    
    System.out.println("Queue vacía:"+q.toString()); 
    
    if(q.empty()){
        System.out.println("El método q.empty() funciona correctamente");
        if(q.peekFirst()==null){
            System.out.println("El método q.peekfirst funciona correctamente"); 
        }
    }
    if(q.free()>0){
        System.out.println("El método q.free() funciona correctamente");
    }
    if(!q.full()){
        System.out.println("El método q.full() funciona correctamente");    
    }
    if(!(q.size()>0)){
        System.out.println("El método q.size() funciona correctamente");
    }
    
    // meter mas contenido para ver si se realiza una cola circular o que le ocurre a la cola despues de que este llena
    
    while(i<=9){
        q.put(i);
        i = i+1;   
    }
    
    System.out.println(q.toString());
    
    if(!q.empty()){ 
        System.out.println("El método q.empty() funciona correctamente"); 
    }
    if(q.free()==0){
        System.out.println("El método q.free() funciona correctamente");
    }
    if(q.full()){
        System.out.println("El método q.full() funciona correctamente");    
    }
    if(q.size()>0){
        System.out.println("El método q.size() funciona correctamente");
    }
       
  }
}
