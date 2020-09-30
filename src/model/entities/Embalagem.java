package model.entities;

import java.io.Serializable;

import model.entities.pk.EmbalagemPK;

public class Embalagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EmbalagemPK id_Produto_MP = new EmbalagemPK();
	
	private Integer id_Produto_MP_PK;
	private Double custoMP;
	private Double qtEmbalagem;
	private Double custoEmbalagem;

	
	
	public Embalagem() {
	}

	public Embalagem(Integer id_Produto_MP_PK, MP mp, Produto produto, Double qtEmbalagem) {
		this.id_Produto_MP_PK = id_Produto_MP_PK;
		id_Produto_MP.setMp(mp);
		id_Produto_MP.setProduto(produto);
		this.custoMP = mp.getCustoMP();
		this.qtEmbalagem = qtEmbalagem;
		this.custoEmbalagem = mp.getCustoMP() * qtEmbalagem;
	}

	
	
	public MP getMP() {
		return id_Produto_MP.getMp();
	}

	public void setMP(MP mp) {
		id_Produto_MP.setMp(mp);
	}

	public Produto getProduto() {
		return id_Produto_MP.getProduto();
	}

	public void setProduto(Produto produto) {
		id_Produto_MP.setProduto(produto);
	}

	public Integer getId_Produto_MP_PK() {
		return id_Produto_MP_PK;
	}

	public void setId_Produto_MP_PK(Integer id_Produto_MP_PK) {
		this.id_Produto_MP_PK = id_Produto_MP_PK;
	}

	public Double getCustoMP() {
		return custoMP;
	}

	public void setCustoMP(Double custoMP) {
		this.custoMP = custoMP;
		
		this.updateCustoEmbalagem();
	}

	public Double getQtEmbalagem() {
		return qtEmbalagem;
	}

	public void setQtEmbalagem(Double qtEmbalagem) {
		this.qtEmbalagem = qtEmbalagem;
		
		this.updateCustoEmbalagem();
	}

	public Double getCustoEmbalagem() {
		return custoEmbalagem;
	}

	public void setCustoEmbalagem(Double custoEmbalagem) {
		this.custoEmbalagem = custoEmbalagem;
	}
	
	public void updateCustoEmbalagem() {
		
		this.custoEmbalagem = this.getQtEmbalagem()*this.custoMP;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Produto_MP_PK == null) ? 0 : id_Produto_MP_PK.hashCode());
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
		Embalagem other = (Embalagem) obj;
		if (id_Produto_MP_PK == null) {
			if (other.id_Produto_MP_PK != null)
				return false;
		} else if (!id_Produto_MP_PK.equals(other.id_Produto_MP_PK))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Embalagem [id_Produto_MP_PK=" + id_Produto_MP_PK + ", id_MP=" + this.getMP().getIdMP() + ", id_Produto=" + this.getProduto().getIdProduto()
				+ " custoMP=" + custoMP + ", qtEmbalagem="
				+ qtEmbalagem + ", custoEmbalagem=" + custoEmbalagem + "]";
	}
}