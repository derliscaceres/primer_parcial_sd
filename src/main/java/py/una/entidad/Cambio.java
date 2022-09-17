package py.una.entidad;
import java.util.ArrayList;
import java.util.List;

public class Cambio {

	String identi;
	Long compra;
	Long venta;
	
		
	public Cambio(){
		this.identi = "";
		this.compra = 0L;
		this.venta = 0L;
	}

	public Cambio(String bIdenti, long bCompra, long bVenta){
		this.identi = bIdenti;
		this.compra = bCompra;
		this.venta = bVenta;
		
	}
	
	public String getIdenti() {
		return identi;
	}

	public void setIdenti(String l) {
		this.identi = l;
	}

	public Long getCompra() {
		return compra;
	}

	public void setCompra(Long compra) {
		this.compra = compra;
	}

	public Long getVenta() {
		return venta;
	}

	public void setVenta(Long venta) {
		this.venta = venta;
	}
}
