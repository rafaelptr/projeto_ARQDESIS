package model;

public class Aeronave {
	
	private int id;
	private String codigo;
	private String nome;
	private int total_assentos;
	private int qtd_assentos_A;
	private int qtd_assentos_B;
	private int qtd_assentos_C;
	private int qtd_assentos_horizontais;
	private int qtd_assentos_verticais;

	public Aeronave(){
		this.id = 0;
		this.codigo = "";
		this.nome = "";
		this.total_assentos = 0;
		this.qtd_assentos_A = 0;
		this.qtd_assentos_B = 0;
		this.qtd_assentos_C = 0;
		this.qtd_assentos_horizontais = 0;
		this.qtd_assentos_verticais = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotal_assentos() {
		return this.qtd_assentos_A + this.qtd_assentos_B + this.qtd_assentos_C;
	}

	public int getQtd_assentos_A() {
		return qtd_assentos_A;
	}

	public void setQtd_assentos_A(int qtd_assentos_A) {
		this.qtd_assentos_A = qtd_assentos_A;
	}

	public int getQtd_assentos_B() {
		return qtd_assentos_B;
	}

	public void setQtd_assentos_B(int qtd_assentos_B) {
		this.qtd_assentos_B = qtd_assentos_B;
	}

	public int getQtd_assentos_C() {
		return qtd_assentos_C;
	}

	public void setQtd_assentos_C(int qtd_assentos_C) {
		this.qtd_assentos_C = qtd_assentos_C;
	}

	public int getQtd_assentos_horizontais() {
		return qtd_assentos_horizontais;
	}

	public void setQtd_assentos_horizontais(int qtd_assentos_horizontais) {
		this.qtd_assentos_horizontais = qtd_assentos_horizontais;
	}

	public int getQtd_assentos_verticais() {
		return qtd_assentos_verticais;
	}

	public void setQtd_assentos_verticais(int qtd_assentos_verticais) {
		this.qtd_assentos_verticais = qtd_assentos_verticais;
	}
	
	
}

