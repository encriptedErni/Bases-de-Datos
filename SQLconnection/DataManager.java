package panaderias;

import java.util.ArrayList;

public class DataManager {

	public static ArrayList<Empleado> getEmpleadosFromDB(DBConnection conn, boolean sync) {
		ArrayList<Empleado> empleados = new ArrayList<>();

		try {
			String query = "SELECT * FROM empleado";
			ResultSet resultSet = conn.executeQuery(query);

			while (resultSet.next()) {
				int id_empleado = resultSet.getInt("id_empleado");
				String n_ss = resultSet.getString("n_ss");
				String nombre = resultSet.getString("nombre");
				String apellido1 = resultSet.getString("apellido1");
				String apellido2 = resultSet.getString("apellido2");

				Empleado empleado = new Empleado(id_empleado, n_ss, nombre, apellido1, apellido2);
				empleado.setSync(sync);
				empleados.add(empleado);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return empleados;
	}

	public static ArrayList<Empleado> getEmpleadosFromCSV(String filename, DBConnection conn, boolean sync) {
		ArrayList<Empleado> empleados = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;

			// Ignorar la primera línea de cabecera
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(";");

				int id_empleado = Integer.parseInt(data[0]);
				String n_ss = data[1];
				String nombre = data[2];
				String apellido1 = data[3];
				String apellido2 = data[4];

				Empleado empleado = new Empleado(id_empleado, n_ss, nombre, apellido1, apellido2);
				empleado.setSync(sync);
				empleados.add(empleado);
			}

			reader.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return null;
		}

		return empleados;
	}

	public static ArrayList<Local> getLocalesFromDB(DBConnection conn, boolean sync) {
		ArrayList<Local> locales = new ArrayList<>();

		try {
			String query = "SELECT * FROM local";
			ResultSet resultSet = conn.executeQuery(query);

			while (resultSet.next()) {
				int id_local = resultSet.getInt("id_local");
				String direccion = resultSet.getString("direccion");
				int capacidad = resultSet.getInt("capacidad");

				Local local = new Local(id_local, direccion, capacidad);
				local.setSync(sync);
				locales.add(local);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return locales;
	}

	public static ArrayList<Local> getLocalesFromCSV(String filename, DBConnection conn, boolean sync) {
		ArrayList<Local> locales = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;

			// Ignorar la primera línea de cabecera
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(";");

				int id_local = Integer.parseInt(data[0]);
				String direccion = data[1];
				int capacidad = Integer.parseInt(data[2]);

				Local local = new Local(id_local, direccion, capacidad);
				local.setSync(sync);
				locales.add(local);
			}

			reader.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return null;
		}

		return locales;
	}

}
