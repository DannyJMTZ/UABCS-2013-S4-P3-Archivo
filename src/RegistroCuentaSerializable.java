import java.io.Serializable;


public class RegistroCuentaSerializable implements Serializable{
	
	private int cuenta;
	private String nombre;
	private String apellido;
	private double saldo;
	
	public RegistroCuentaSerializable(){
		
		this.cuenta = 0;
		this.nombre = "";
		this.apellido = "";
		this.saldo = 0.0;
		
	}
	
	public RegistroCuentaSerializable( int cta , String nombre , String apellido , double saldo ){
		
		this.cuenta = cta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.saldo = saldo;
		
	}
	
	public int getCuenta() { return cuenta; }
	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public double getSaldo() { return saldo; }
	
	public void setCuenta(int cuenta) { this.cuenta = cuenta; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public void setSaldo(double saldo) { this.saldo = saldo; }
	
}
