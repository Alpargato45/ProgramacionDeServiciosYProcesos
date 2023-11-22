package problemafilosofosconsemaforos;

import java.util.concurrent.Semaphore;

public class ProblemaFilosofosConSemaforos {

    public static void main(String[] args) {

        int numFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        Semaphore[] tenedores = new Semaphore[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Semaphore(1);
        }

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % numFilosofos]);
            filosofos[i].start();
        }
    }
}
