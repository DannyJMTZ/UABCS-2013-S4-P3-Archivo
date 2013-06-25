
public class Main {
	
	
	
	public static void main(String[] args) {
		
		/*CrearArchivoSecuencial aplicacion = new CrearArchivoSecuencial();
		aplicacion.abrirArchivo("clientes.txt" );
		aplicacion.agregarRegistro();
		aplicacion.cerrarArchivo();
		*/
		
		LeerArchivoSecuencial app = new LeerArchivoSecuencial();
		app.abrirArchivo( "clientes.txt" );
		app.leerRegistro();
		app.cerrarArchivo();
		
	}

}
