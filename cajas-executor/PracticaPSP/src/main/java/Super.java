import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Super {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int compradores = 0;
        int cajas = 0;
        Semaphore pago = new Semaphore(1);
        Semaphore linea = new Semaphore(0);
	Semaphore salida = new Semaphore(compradores);
        
	compradores = Carros();
        System.out.print("N\u00F2mero de clientes: " + compradores);
        
        Clientes cola = new Clientes(compradores);
        
        System.out.println("N\u00F2mero de Cajas: " + cajas);
        
        Caja[] caja = new Caja[1];
        while(cajas <= 0){
            cajas = 0;
            System.out.println("Introduzca cuántas cajas quiere en su local: ");
            cajas = sc.nextInt();
        }

        for(int i = 0; i < cajas; i++) {
            caja[i] = new Caja("Caja " + (i + 1), pago, cola, linea, salida);
            caja[i].start();
	}
    }
    
    public static int Carros() {
    long base = System.currentTimeMillis();
    int compradores = (int) base;
    int resultado = compradores % 30 + 1;
    return resultado;
    }
}
