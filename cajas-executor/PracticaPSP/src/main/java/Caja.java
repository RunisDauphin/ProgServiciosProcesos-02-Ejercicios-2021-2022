import java.util.concurrent.Semaphore;

public class Caja extends Thread {
    private Semaphore pago, linea, salida;
    private Clientes cola;

    public Caja(String nombre, Semaphore mutex, Clientes cola, Semaphore clientesEsperando, Semaphore clientesDespachados) {
	super(nombre);
	this.pago = pago;
	this.linea = linea;
	this.salida = salida;
	this.cola = cola;
	}

    public void Procedimiento() {
	while (true) {
            try {
		salida.acquire();
		pago.acquire();
		System.out.println(getName() + " atiende al cliente " + cola.ResolucionCliente());
		cola.SumaElementos();
		System.out.println("Se ha tardado " + cola.TotalElementos() + " segundos");
		pago.release();
		linea.release();
            }
            catch (Exception e) {
            }
	}
    }
}
