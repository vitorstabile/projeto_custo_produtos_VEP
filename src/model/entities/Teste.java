package model.entities;

import java.io.Serializable;

import model.entities.pk.TestePK;

public class Teste implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private TestePK id_Produto_Receita = new TestePK();
	
	private Integer id_Produto_Receita_PK;
	private Double gramaturaTeste;
	
	
	
	public Teste() {
	}

	public Teste(Integer id_Produto_Receita_PK, Produto produto, Receita receita, Double gramaturaTeste) {
		this.id_Produto_Receita_PK = id_Produto_Receita_PK;
		id_Produto_Receita.setProduto(produto);
		id_Produto_Receita.setReceita(receita);
		this.gramaturaTeste = gramaturaTeste;
	}
	
	
	
	public Produto getProduto() {
		return id_Produto_Receita.getProduto();
	}

	public void setProduto(Produto produto) {
		id_Produto_Receita.setProduto(produto);
	}
	
	public Receita getReceita() {
		return id_Produto_Receita.getReceita();
	}

	public void setReceita(Receita receita) {
		id_Produto_Receita.setReceita(receita);
	}

	public Integer getId_Produto_Receita_PK() {
		return id_Produto_Receita_PK;
	}

	public void setId_Produto_Receita_PK(Integer id_Produto_Receita_PK) {
		this.id_Produto_Receita_PK = id_Produto_Receita_PK;
	}

	public Double getGramaturaTeste() {
		return gramaturaTeste;
	}

	public void setGramaturaTeste(Double gramaturaTeste) {
		this.gramaturaTeste = gramaturaTeste;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Produto_Receita_PK == null) ? 0 : id_Produto_Receita_PK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teste other = (Teste) obj;
		if (id_Produto_Receita_PK == null) {
			if (other.id_Produto_Receita_PK != null)
				return false;
		} else if (!id_Produto_Receita_PK.equals(other.id_Produto_Receita_PK))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Teste [id_Produto_Receita_PK=" + id_Produto_Receita_PK + ", id_Produto=" + this.getProduto().getIdProduto() + ", id_Receita=" + this.getReceita().getIdReceita()
				+ ", gramaturaTeste=" + gramaturaTeste + "]";
	}
}