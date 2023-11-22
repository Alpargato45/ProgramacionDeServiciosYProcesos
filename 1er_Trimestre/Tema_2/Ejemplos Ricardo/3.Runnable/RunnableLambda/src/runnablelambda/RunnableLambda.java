package runnablelambda;

/**
 *
 * @author Ricardo
 * 
 **/

public class RunnableLambda {
    
    
     public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Procesando hilo." + finalI);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
