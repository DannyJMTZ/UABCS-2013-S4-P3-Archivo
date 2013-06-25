import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LeerArchivoSecuencial {
	
	private ObjectInputStream input;
	
	public void abrirArchivo( String ruta ){
		
			try { input = new ObjectInputStream( new FileInputStream(ruta));} 
			catch (FileNotFoundException e) { e.printStackTrace(); } 
			catch (IOException e) { e.printStackTrace(); }
	}
	
	public void leerRegistro(){

		RegistroCuentaSerializable registro;
		
		System.out.printf("%-10s%-15s%-15s%10s\n" ,"Cuenta" , "Nombre" , "Apellido" , "Saldo" );
		
		while( true ){
			
			try { 
				
				registro = (RegistroCuentaSerializable) input.readObject();
				
				System.out.printf("%-10d%-15s%-15s%11.2f\n", registro.getCuenta() , registro.getNombre() , registro.getApellido() , registro.getSaldo() );
				
			}
			catch (EOFException e) { return; }
			catch (ClassNotFoundException e) { e.printStackTrace(); } 
			catch (IOException e) { e.printStackTrace(); }
			
		}
	}

	public void cerrarArchivo(){
		
		if( input != null){
			
			try { input.close(); System.exit( 1 ); } catch (IOException e) { e.printStackTrace(); }
			
		}
		
	}

}
