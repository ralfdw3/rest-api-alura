package med.voll.api;

import java.sql.DriverManager;

public class Teste {

	public static void main(String[] args) {

		try {
			DriverManager.getConnection("jdbc:mysql://localhost/vollmed_api", "root", "root");
			System.out.println("conectado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
