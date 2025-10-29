package practica3;

import util.Const;
import util.TCPSegment;
import util.TSocket_base;
import util.SimNet;

public class TSocketSend extends TSocket_base {
    
    protected int MSS;       // Maximum Segment Size

    public TSocketSend(SimNet network) {
        super(network);
        MSS = network.getMTU() - Const.IP_HEADER - Const.TCP_HEADER;
    }
    
    @Override
    public void sendData(byte[] data, int offset, int length) {
        TCPSegment seg;
        while (length>0) {
            int fragmentSize = Math.min(MSS, length);                        
            seg = this.segmentize(data, offset, fragmentSize);
            offset = offset + fragmentSize;
            length = length - fragmentSize;
            msg.setPsh(true);
            printSndSeg(seg);
            network.send(seg);
        }
    }
    
    protected TCPSegment segmentize(byte[] data, int offset, int length) {
        TCPSegment seg = new TCPSegment();        
        seg.setData(data, offset, length);
        seg.setPsh(true);
        return seg;        
    }
    
}
