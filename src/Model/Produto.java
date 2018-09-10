package Model;

public class Produto {
	private int id;
	private String Nome;
	private int QtdProduto;
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public int getQtdProduto() {
		return QtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.QtdProduto = qtdProduto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
