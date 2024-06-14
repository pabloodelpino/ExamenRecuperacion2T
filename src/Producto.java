
public class Producto {
	
	private int codigo;
	private String descripcion;
	protected double precio;
	
	public Producto(int codigo, String descripcion, double precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		
		if (precio < 0) {
			precio = 0;
		} else {
			this.precio = precio;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
            this.precio = precio;
        }
	}
}
