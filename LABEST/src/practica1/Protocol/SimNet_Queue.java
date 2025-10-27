package practica1.Protocol;

import java.util.concurrent.locks.ReentrantLock;
import practica1.CircularQ.CircularQueue;
import util.Const;
import util.TCPSegment;
import util.SimNet;

public class SimNet_Queue implements SimNet {

  CircularQueue<TCPSegment> queue;
  private ReentrantLock mon;
  private TCPSegment mensaje;
  
  // que atributos tendre que meter aqui, TENGO UNA FOTO DE UNA GUIA QUE NOS DIO EL PROFE EN EL LAB

  public SimNet_Queue() {
    queue = new CircularQueue<>(Const.SIMNET_QUEUE_SIZE);
  }

  @Override
  public void send(TCPSegment s) {
    //throw new RuntimeException("//Completar...");
    
  }

  @Override
  public TCPSegment receive() {
    //throw new RuntimeException("//Completar...");
    TCPSegment segment = new TCPSegment();
    segment.setSourcePort(12345);   // provisional para que no nos salte los warnings de los returns
    segment.setDestinationPort(80);
    segment.setSequenceNumber(1000);
    return segment;
    
  }

  @Override
  public int getMTU() {
    //throw new UnsupportedOperationException("Not supported yet. No cal completar en aquesta pràctica");
    int tmp = 9;
    return tmp;
  }
}
