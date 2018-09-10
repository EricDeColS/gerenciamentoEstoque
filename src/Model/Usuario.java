package Model;

public class Usuario {
	private int id;
	private String User;
	private String Senha;
	private String Nome;
	private int Cpf;
	private int Rg;
	private String Endereco;
	private String DataNasc;
	private boolean Admin;
	private double Salario;
	private String Cargo;
	

public Usuario(String user, String senha, String nome, int cpf, int rg, String endereco, String dataNasc){
	this.User = user;
	this.Senha = senha;
	this.Nome = nome;
	this.Cpf = cpf;
	this.Rg = rg;
	this.Endereco = endereco;
	this.DataNasc = dataNasc;

}



public boolean isAdmin() {
	return Admin;
}

public void setAdmin(boolean admin) {
	Admin = admin;
}

public String getUser() {
	return User;
}

public void setUser(String user) {
	User = user;
}

public String getSenha() {
	return Senha;
}

public void setSenha(String senha) {
	Senha = senha;
}



public String getNome() {
	return Nome;
}



public void setNome(String nome) {
	Nome = nome;
}



public int getCpf() {
	return Cpf;
}



public void setCpf(int cpf) {
	Cpf = cpf;
}



public int getRg() {
	return Rg;
}



public void setRg(int rg) {
	Rg = rg;
}



public String getEndereco() {
	return Endereco;
}



public void setEndereco(String endereco) {
	Endereco = endereco;
}



public String getDataNasc() {
	return DataNasc;
}



public void setDataNasc(String dataNasc) {
	DataNasc = dataNasc;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public double getSalario() {
	return Salario;
}



public void setSalario(double salario) {
	Salario = salario;
}



public String getCargo() {
	return Cargo;
}



public void setCargo(String cargo) {
	Cargo = cargo;
}

}