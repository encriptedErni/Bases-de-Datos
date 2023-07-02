package panaderias;

public class Empleado extends DBTable {
	
	private int id_empleado;
	private String n_ss;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public Empleado(int id_empleado, DBConnection conn, boolean DBSync) {
		super(conn, DBSync);
		this.id_empleado = id_empleado;
		
	}
	
	public Empleado(int id_empleado, String n_ss, String nombre, String apellido1, String apellido2, DBConnection conn, boolean DBSync) {
		super(conn, DBSync);
		this.id_empleado = id_empleado;
		this.n_ss = n_ss;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	
	public String getN_ss() {
		return n_ss;
	}

	public void setN_ss(String n_ss) {
		this.n_ss = n_ss;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public void destroy() {
		if (DBSync) {
			deleteEntry();
		}
		this.id_empleado = -1;
		this.n_ss = null;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.setSync(false);
	}
	
	
	boolean createTable() {
	    if (DBSync) {
	        // Implementa el código para ejecutar el comando de creación de la tabla correspondiente
	        // Retorna true si el comando se ejecuta sin errores y false en caso contrario
	    }
	    return false;
	}

	boolean insertEntry() {
	    if (DBSync) {
	        // Implementa el código para ejecutar el comando de inserción del elemento actual en la base de datos
	        // Retorna true si el elemento se ha insertado y false en caso contrario
	    }
	    return false;
	}

	boolean updateEntry() {
	    if (DBSync) {
	        // Implementa el código para ejecutar el comando de actualización del elemento actual en la base de datos
	        // Retorna true si el elemento se ha actualizado y false en caso contrario
	    }
	    return false;
	}

	boolean deleteEntry() {
	    if (DBSync) {
	        // Implementa el código para ejecutar el comando de borrado del elemento actual en la base de datos
	        // Retorna true si el elemento se ha borrado y false en caso contrario
	    }
	    return false;
	}

	void getEntryChanges() {
	    if (DBSync) {
	        // Implementa el código para ejecutar el comando SELECT y actualizar los atributos del objeto desde la base de datos
	    }
	}
}
