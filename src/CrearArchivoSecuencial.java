import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;


public class CrearArchivoSecuencial {
	
	private ObjectOutputStream salida;
	
	public void abrirArchivo( String ruta ){
		
		try { salida = new ObjectOutputStream( new FileOutputStream( ruta ) ); } 
		catch (FileNotFoundException e) { System.err.println("Error: No se encontro el archivo"); } 
		catch (IOException e) { System.err.println("Error: Flujo de salida"); }
		finally{ System.err.println("Error: TU MAMA D:"); }
		
		
	}
	
	public void agregarRegistro(){
		
		RegistroCuentaSerializable registro;
		
		int numeroCuenta = 0;
		String nombre;
		String apellido;
		double saldo;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.printf( "%s\n%s\n%s\n%s\n\n" , 
				"Para terminar de introducir los datos, escriba el indicador de fin de archivo" , 
				"Cuando se le pida que introduzca los datos" ,
				"En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima enter" ,
				"En Windows escriba <ctrl> z y oprima enter" );
		
		System.out.printf( "%s\n%s" , "Escribe el numero de cuenta ( > 0), nombre, apellido, saldo" , "? " );
		
		while( input.hasNext() ){
			
			numeroCuenta = input.nextInt();
			nombre = input.next();
			apellido = input.next();
			saldo = input.nextDouble();
			
			if( numeroCuenta > 0 ){
				
				registro = new RegistroCuentaSerializable( numeroCuenta , nombre , apellido , saldo );
				try { salida.writeObject( registro ); } 
				catch (IOException e) { 
					System.err.println( "Error: al escribir al archivo" );
					return;
				}
				catch (NoSuchElementException e) { 
					System.err.println("Error: Entrada no Valida");
					input.nextLine();
				}
				
				System.out.printf( "%s %s\n%s", "Enter account number (>0),",
									"first name, last name and balance.", "? " );
				
			}
			else
				System.out.println("El numero de cuenta tiene que ser mayor a 0");
			
		}
		
	}
	
	public void cerrarArchivo(){
		
		if( salida != null )
			try { salida.close(); } catch (IOException e) { System.err.println("Error al Cerrar Archivo"); System.exit( 1 );}
		
	}
	
}
