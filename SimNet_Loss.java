package practica3;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import util.Const;
import util.Log;
import util.TCPSegment;

public class SimNet_Loss extends practica2.Protocol.SimNet_Monitor {

    private double lossRate;
    private Random rand;
    private Log log;
    private ReentrantLock l = new ReentrantLock();
    private Condition colaLlena = l.newCondition();
    private Condition colaVacia = l.newCondition();

    public SimNet_Loss(double lossRate) {
        this.lossRate = lossRate;
        rand = new Random(Const.SEED);
        log = Log.getLog();
    }

   /* @Override
    public void send(TCPSegment seg) {
        l.lock();
        try {
            while (queue.full()) {
                colaLlena.awaitUninterruptibly();
            }
            if (rand.nextDouble() > this.lossRate) {
                super.send(seg);
                colaVacia.signal();
            }
        } finally {
            l.unlock();
        }
    }

    /*
    @Override
    public TCPSegment receive() {
        l.lock();
        try {
            TCPSegment seg = new TCPSegment();
            while (!queue.empty()) {
                colaVacia.awaitUninterruptibly();
            }
            seg = super.receive();
            colaLlena.signal();
            return seg;
        } finally {
            l.unlock();
        }
    }
     */

    @Override
    public int getMTU() {
        return Const.MTU_ETHERNET;
    }
}
