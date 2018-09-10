/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric
 */
public class UsuarioDAO {
    public List<Usuario> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Usuario> usuarios = new ArrayList<>();
		
		
		try{
		stmt = con.prepareStatement("SELECT * FROM usuario");
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Usuario u = new Usuario();
			u.setId(rs.getInt("id"));
			u.setUser(rs.getString("user"));
			u.setSenha(rs.getString("senha"));
			u.setNome(rs.getString("nome"));
                        u.setCpf(rs.getInt("cpf"));
                        u.setRg(rs.getInt("rg"));
                        u.setEndereco(rs.getString("endereco"));
			u.setDataNasc(rs.getString("datanasc"));
                        u.setAdmin(rs.getBoolean("admin"));
                        u.setSalario(rs.getDouble("salario"));
                        u.setCargo(rs.getString("cargo"));
			usuarios.add(u);
			
		}
		
		} catch (SQLException e) {
			System.err.println("Nao foi possível obter usuário"+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return usuarios;
				
	}

    /**
     *
     * @param user
     * @param senha
     * @return
     */
    public boolean checkLogin(String user, String senha){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
                boolean check = false;
				
		
		try{
		stmt = con.prepareStatement("SELECT * FROM usuario WHERE user = ? and senha = ?");
                stmt.setString(1, user);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
		
		if (rs.next()) {
			check = true;
			
		}
		
		} catch (SQLException e) {
			System.err.println("Usuário ou senha incorretos"+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return check;
				
	}
}
