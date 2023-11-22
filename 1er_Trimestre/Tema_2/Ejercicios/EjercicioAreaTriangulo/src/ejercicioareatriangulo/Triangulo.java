package ejercicioareatriangulo;



public class Triangulo extends Thread{
    
    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    
    public static double calcularArea(int base, int altura) {
        return (base*altura/2);
    }
    
    @Override
    public void run() {
        System.out.println("Base: " + base + " Altura: " + altura + " Resultado: " + calcularArea(base,altura));
    }
    
}
