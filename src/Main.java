import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);	
		String opcion = "";
		boolean continuar = true;
		
		Map <Integer, Factura> misFacturas = new HashMap<>();

		while (continuar) {
			System.out.println("-----------------------------------");
			System.out.println("A. Crear factura.");
			System.out.println("B. Mostrar facturas.");
			System.out.println("C. Añadir producto a factura.");
			System.out.println("D. Eliminar producto de la factura.");
			System.out.println("E. Mostrar total de una factura.");
			System.out.println("");
			System.out.println("(Cualquier otra cosa). Salir.");
			System.out.println("-----------------------------------");
			
			opcion = sc.nextLine();
			
			if (opcion.compareToIgnoreCase("A")==0) {
				System.out.print("\nIngrese el código de la factura: ");
		        int codigoFactura = Integer.valueOf(sc.nextLine());
		        System.out.print("Ingrese la fecha de la factura: ");
		        String fecha = sc.nextLine();

		        Factura nuevaFactura = new Factura(fecha, codigoFactura);
		        misFacturas.put(codigoFactura, nuevaFactura);

		        System.out.println("\nFactura creada exitosamente.");

			} else if (opcion.compareToIgnoreCase("B")==0) {			
				if (misFacturas.isEmpty()) {
		            System.out.println("\nNo hay facturas para mostrar.");
		        }

		        for (Factura f : misFacturas.values()) {
		            System.out.println("\nCódigo: " + f.getCodigoFactura() + " y fecha: " + f.getFecha());
		            LineaFactura[] lineas = f.getDatosFactura();
		            for (LineaFactura linea : lineas) {
		                System.out.println("Producto: " + linea.getMiProducto().getCodigo() + ", descripción: " + linea.getMiProducto().getDescripcion() + ", precio: " + linea.getMiProducto().getPrecio() + ", cantidad: " + linea.getCantidad() + " y total: " + linea.getTotal());
		            }
		        }

			} else if (opcion.compareToIgnoreCase("C")==0) {
				System.out.print("\nIngrese el código de la factura: ");
		        int codigoFactura = Integer.valueOf(sc.nextLine());

		        Factura f = misFacturas.get(codigoFactura);
		        
		        if (f == null) {
		            System.out.println("\nFactura no encontrada.");
		        } else {
			        System.out.print("Ingrese el código del producto: ");
			        int codigoProducto = Integer.valueOf(sc.nextLine());
	
			        LineaFactura productoExistente = f.buscarLineaFactura(codigoProducto);
			        
			        if (productoExistente != null) {
			            System.out.println("\nEl producto ya está en la factura.");
			        } else {	        
				        System.out.print("Ingrese la descripción del producto: ");
				        String descripcion = sc.nextLine();
		
				        System.out.print("Ingrese el precio del producto: ");
				        double precio = Double.valueOf(sc.nextLine());
		
				        System.out.print("Ingrese la cantidad de ese producto: ");
				        int cantidad = Integer.valueOf(sc.nextLine());

				        Producto p = new Producto(codigoProducto, descripcion, precio);
				        
				        LineaFactura lf = new LineaFactura(p, cantidad);
				        f.addFactura(lf);
				        
				        System.out.println("\nProducto añadido exitosamente a la factura.");
			        }
		        }

			} else if (opcion.compareToIgnoreCase("D")==0) {
				System.out.print("\nIngrese el código de la factura: ");
		        int codigoFactura = Integer.valueOf(sc.nextLine());

		        Factura f = misFacturas.get(codigoFactura);
		        
		        if (f == null) {
		            System.out.println("\nFactura no encontrada.");
		        } else {
			        System.out.print("Ingrese el código del producto: ");
			        int codigoProducto = Integer.valueOf(sc.nextLine());
	
			        LineaFactura productoEncontrado = f.buscarLineaFactura(codigoProducto);
			        
			        if (productoEncontrado == null) {
			            System.out.println("\nEl producto no se ha encontrado en la factura.");
			        } else {		        
				        f.removeLineaFactura(codigoProducto);
				        System.out.println("\nProducto eliminado exitosamente de la factura.");
			        }
		        }

			} else if (opcion.compareToIgnoreCase("E")==0) {
				System.out.print("Ingrese el código de la factura: ");
		        int codigoFactura = Integer.valueOf(sc.nextLine());

		        Factura f = misFacturas.get(codigoFactura);
		        
		        if (f == null) {
		            System.out.println("\nFactura no encontrada.");
		        } else {
		        	System.out.println("\nTotal de la factura: " + f.getTotalFactura());
		        }
		        
			} else {
				continuar = false;

			}
		}
		sc.close();
	}
}
