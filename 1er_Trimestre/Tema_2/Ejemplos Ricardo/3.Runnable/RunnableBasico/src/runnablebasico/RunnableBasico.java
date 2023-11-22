
package runnablebasico;


public class RunnableBasico implements Runnable{

   private int id;
   
   public RunnableBasico(int id) {
       this.id = id;
   }
   
   @Override
    public void run() {
        while (true) {
            System.out.println("Procesando hilo " + this.id);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
       for (int i = 0; i < 10; i++) {
           new Thread(new RunnableBasico(i)).start();
       }
    }

    
    
}
