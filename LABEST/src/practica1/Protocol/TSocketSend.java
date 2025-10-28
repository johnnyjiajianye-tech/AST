package practica1.Protocol;

import util.TCPSegment;
import util.TSocket_base;
import util.SimNet;

public class TSocketSend extends TSocket_base {

  public TSocketSend(SimNet network) {
    super(network);
  }

  @Override
  public void sendData(byte[] data, int offset, int length) {
    //throw new RuntimeException("//Completar...");
    TCPSegment tmp = new TCPSegment();
    byte[] dataUtil = new byte[length];
//    for(int i=0;i<length;i++){  //Hay una manera mas optima de hacerlo
//        dataUtil[i] = data[offset+i];
//        printSndSeg(tmp);
//    }

    tmp.setData(data, offset, length);
    tmp.setPsh(true);   //Activa el flag
    network.send(tmp);  //Envia el missatge al Network
    System.out.println("Sender: transmission finished");
  }
}
