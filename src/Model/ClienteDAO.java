package Model;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
	
	private Connection con = null;
	
	public ClienteDAO() {
		con = ConnectionFactory.getConnection();
		
	}

	public boolean update(Cliente cliente){
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO cliente (nome) VALUES (?)");
			stmt.setString(1, cliente.getNome());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("FODELS AEAEEAE"+ e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}		
} //final brackets