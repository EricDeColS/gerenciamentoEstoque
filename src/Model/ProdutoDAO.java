package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ProdutoDAO {
	private Connection con = null;

	public ProdutoDAO() {
		con = ConnectionFactory.getConnection();
		
	}
	
	public void create(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try{
			stmt = con.prepareStatement("INSERT INTO produto (Nome, QtdProduto) VALUES (?,?)");
			stmt.setString(1, p.getNome());
			stmt.setInt(2, p.getQtdProduto());
		
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
		} catch (SQLException e) {
			System.err.println("Nao foi possível criar este produto"+ e);
			JOptionPane.showMessageDialog(null, "Produto não pode ser salvo");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		
		}
	}
	
	
	public List<Produto> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Produto> produtos = new ArrayList<>();
		
		
		try{
		stmt = con.prepareStatement("SELECT * FROM produto");
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Produto prod = new Produto();
			prod.setId(rs.getInt("id"));
			prod.setNome(rs.getString("nome"));
			prod.setQtdProduto(rs.getInt("qtdproduto"));
			produtos.add(prod);
			
		}
		
		} catch (SQLException e) {
			System.err.println("Nao foi possível obter produto"+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return produtos;
				
	}
	
	public boolean update(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE produto SET nome=?, qtdproduto=? WHERE id=?");
			stmt.setString(1, p.getNome());
                        stmt.setInt(2, p.getQtdProduto());
                        stmt.setInt(3, p.getId());
                        
			stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, p.getNome()+ "atualizado com sucesso");
			return true;
		} catch (SQLException e) {
			System.err.println("Não foi possível atualizar o Produto"+ e);
                        JOptionPane.showMessageDialog(null, "Produto não pode ser atualizado");
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		
		
	}
	
}
