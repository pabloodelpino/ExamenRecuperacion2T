
public class LineaFactura {

	private Producto miProducto;
	private int cantidad;
	
	public LineaFactura(Producto miProducto, int cantidad) {
		this.miProducto = miProducto;
		if (cantidad <= 0) {
			cantidad = 1;
		} else {
			this.cantidad = cantidad;
		}
	}
	
	public Producto getMiProducto() {
		return miProducto;
	}

	public void setMiproducto(Producto miProducto) {
		this.miProducto = miProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		if (cantidad > 0) {
            this.cantidad = cantidad;
        }
	}

	public double getTotal() {
		return miProducto.getPrecio() * cantidad;
	}
}
