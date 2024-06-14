import java.util.ArrayList;
import java.util.List;

public class Factura {

	private String fecha;
	private int codigoFactura;

	private List <LineaFactura> misLineasFacturas;
	
	public Factura(String fecha, int codigoFactura) {
		this.fecha = fecha;
		this.codigoFactura = codigoFactura;
		
		misLineasFacturas = new ArrayList<>();
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getCodigoFactura() {
		return codigoFactura;
	}
	
	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	
	public boolean addFactura(LineaFactura nuevaLineaFactura) {
		for (LineaFactura lf : misLineasFacturas) {
            if (lf.getMiProducto().getCodigo() == nuevaLineaFactura.getMiProducto().getCodigo()) {
                return false;
            }
        }		
		return misLineasFacturas.add(nuevaLineaFactura);
	}
	
	public boolean removeLineaFactura(int codigoProducto) {
		for (LineaFactura lf : misLineasFacturas) {
			if (lf.getMiProducto().getCodigo() == codigoProducto) {
				misLineasFacturas.remove(lf);
				return true;
			}
		}		
		return false;
    }
	
	public LineaFactura buscarLineaFactura(int codigoProducto) {
        for (LineaFactura lf : misLineasFacturas) {
            if (lf.getMiProducto().getCodigo() == codigoProducto) {
                return lf;
            }
        }      
        return null;
    }
	
	public LineaFactura[] getDatosFactura() {
		LineaFactura[] nuevaLista = new LineaFactura[misLineasFacturas.size()];

		for (int i = 0; i < nuevaLista.length; i++) {
			nuevaLista[i] = misLineasFacturas.get(i);		
		}		
		return nuevaLista;
		//return misLineasFacturas.toArray(new LineaFactura[0]);
	}
	
	public double getTotalFactura() {
        double total = 0.0;
        
        for (LineaFactura lf : misLineasFacturas) {
            total += lf.getTotal();
        }
        
        return total;
    }
}
