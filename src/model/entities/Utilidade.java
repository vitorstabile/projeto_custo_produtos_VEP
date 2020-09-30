package model.entities;

import java.io.Serializable;

import model.entities.pk.UtilidadePK;

public class Utilidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UtilidadePK id_Produto_Recurso = new UtilidadePK();
	
	private Integer id_Produto_Recurso_PK;

	
	
	public Utilidade() {
	}

	public Utilidade(Integer id_Produto_Recurso_PK, Produto produto, Recurso recurso) {
		this.id_Produto_Recurso_PK = id_Produto_Recurso_PK;
		id_Produto_Recurso.setProduto(produto);
		id_Produto_Recurso.setRecurso(recurso);
	}

	
	
	public Produto getProduto() {
		return id_Produto_Recurso.getProduto();
	}

	public void setProduto(Produto produto) {
		id_Produto_Recurso.setProduto(produto);
	}
	
	public Recurso getRecurso() {
		return id_Produto_Recurso.getRecurso();
	}

	public void setRecurso(Recurso recurso) {
		id_Produto_Recurso.setRecurso(recurso);
	}

	public Integer getId_Produto_Recurso_PK() {
		return id_Produto_Recurso_PK;
	}

	public void setId_Produto_Recurso_PK(Integer id_Produto_Recurso_PK) {
		this.id_Produto_Recurso_PK = id_Produto_Recurso_PK;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Produto_Recurso_PK == null) ? 0 : id_Produto_Recurso_PK.hashCode());
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
		Utilidade other = (Utilidade) obj;
		if (id_Produto_Recurso_PK == null) {
			if (other.id_Produto_Recurso_PK != null)
				return false;
		} else if (!id_Produto_Recurso_PK.equals(other.id_Produto_Recurso_PK))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Utilidade [id_Produto_Recurso_PK=" + id_Produto_Recurso_PK + 
				", id_Produto=" + this.getProduto().getIdProduto() + 
				", id_Recurso=" + this.getRecurso().getIdRecurso() + "]";
	}	
}