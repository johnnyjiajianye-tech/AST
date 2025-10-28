package practica1.Protocol;

import util.TCPSegment;
import util.TSocket_base;
import util.SimNet;

public class TSocketRecv extends TSocket_base {

  public TSocketRecv(SimNet network) {
    super(network);
  }

  @Override
  public int receiveData(byte[] data, int offset, int length) {
    //throw new RuntimeException("//Completar...");
    TCPSegment tmp = network.receive();
    byte[] dataUtil = tmp.getData();
    int nDR = 0;    // nDR=number of Data Receive
    for(int i=0;i<length;i++){  //No se si hay una manera mas optima de hacerlo
        data[offset+i] = dataUtil[i];
        nDR = nDR + 1;
        printRcvSeg(tmp);
        System.out.println("Receiver: received "+nDR+" bytes");
    }
    System.out.println("Receiver: reception finished");
    return nDR; //Saber que tengo que devolver
    
  }
}
