public class Clientes {
    private int elementos;
    private int[] cadena;
    private int actual;
    private int n;

    Clientes(int n) {
        this.elementos = Tiempo();
        this.n = n;
        this.cadena = new int[n];
        this.actual = 0;
    }

    public void SumaElementos() {
        elementos++;
    }

    public int TotalElementos() {
        return elementos;
    }


    public int ResolucionCliente() {
        int carro = cadena[actual];
        actual = (actual + 1) % n;
        return carro;
    }
    
    public static int Tiempo() {
    long base = System.currentTimeMillis();
    int proceso = (int) base;
    int resultado = proceso % 5 + 1;
    return resultado;
    }
}
