package practica1.CircularQ;

import java.util.Iterator;
import util.Queue;

public class CircularQueue<E> implements Queue<E> {

    private final E[] queue;
    private final int N;
    private int G, P, c; // G = head    P = tail    c = capacity, no se si hace falta poner que capacity es final
    protected int n = 0;  // n = number of elements
    
    public CircularQueue(int N) {
        this.N = N;
        queue = (E[]) (new Object[N]);
    }

    @Override
    public int size() {
        // throw new RuntimeException("//Completar...");
        return n; // porque muestra el tamaño consumido de la cola
    }

    @Override
    public int free() {
        // throw new RuntimeException("//Completar...");
        return (N-n);
    }

    @Override
    public boolean empty() {
        // throw new RuntimeException("//Completar...");
        return (n==0);
    }

    @Override
    public boolean full() {
        // throw new RuntimeException("//Completar...");
        return (N==n);
    }

    @Override
    public E peekFirst() {
        // throw new RuntimeException("//Completar...");
        if (this.G==0){
            return null;
        }else
            return queue[G]; // no estoy seguro de si quieren el origen de la cola "0" o al principio de la respectiva cola "G"
    }

    @Override
    public E get() {
        if(n==0){
           // throw new RuntimeException("//Completar..."); 
           return null; //No se si hay que devolver otra cosa
        }else{    
            E tmp = queue[G];   
            queue[G]=null;
            G = (G+1)%c;
            n = n-1;
            return tmp; 
        }
    }

    @Override
    public void put(E e) {
        if(n==N){
            // throw new RuntimeException("//Completar...");            
        }else{
            P = (G+n)%N;
            queue[P] = e;
            n = n+1;            
        } 
    }

    @Override
    public String toString() {
        // throw new RuntimeException("//Completar...");
        String contingut = "["+queue[G%N];
        for(int i=1; i<n;i++){
            int pos=(G+i)%N; // Acabar de entender las lineas de codigo dentro del FOR
            contingut = contingut + ","+queue[pos];
        }
        contingut = contingut +"]"; 
        
        return contingut;
    }

    
    // EJERCICIO 2
    
    
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator {

        protected int loop = 0;
        protected int P; // P = posicion de referencia

        @Override
        public boolean hasNext() {
            //throw new RuntimeException("//Completar...");
            return (loop<n);
        
        }

        @Override
        public E next() {
            //throw new RuntimeException("//Completar...");
            E tmp = queue[((P+loop)%c)]; // no estoy seguro de si tengo que usar la P o la G, porque no se si la P nos la indicaran como referencia o no de las posiciones que queremos consultar o modificar
            // queue[((P+loop)%c)] = null;  ES UN METODO DE CONSULTA
            loop = loop + 1;
            return tmp;
        }

        @Override
        public void remove() {
            //throw new RuntimeException("//Completar...");
            
            
        }

    }
    
    // Ejercicio 3 no nos aporta nada ha dicho el profe, asi que nos lo petamos porque vamos justos de tiempo
    
    // Ejercicio 4 en otra clase SimNet_Queue.java
}
