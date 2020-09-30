package model.entities;

import java.io.Serializable;

import model.entities.pk.IngredientePK;

public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	private IngredientePK id_MP_Receita = new IngredientePK();

	private Integer id_MP_Receita_PK;
	private Double custoMP;
	private Double qtIngredienteBruto;
	private Double perdaIngrediente;
	private Double qtIngredienteLiquido;
	private Double custoIngrediente;
	private Double porcenIngrediente;

	public Ingrediente() {
	}

	public Ingrediente(Integer id_MP_Receita_PK, MP mp, Receita receita, Double qtIngredienteBruto, Double perdaIngrediente) {
		this.id_MP_Receita_PK = id_MP_Receita_PK;
		id_MP_Receita.setMp(mp);
		id_MP_Receita.setReceita(receita);
		this.custoMP = mp.getCustoMP();
		this.qtIngredienteBruto = qtIngredienteBruto;
		this.perdaIngrediente = perdaIngrediente;
		this.qtIngredienteLiquido = (qtIngredienteBruto - qtIngredienteBruto*(perdaIngrediente/100));
		this.custoIngrediente = mp.getCustoMP() * qtIngredienteBruto;
		this.porcenIngrediente = null;
	}

	public MP getMP() {
		return id_MP_Receita.getMp();
	}

	public void setMP(MP mp) {
		id_MP_Receita.setMp(mp);
	}

	public Receita getReceita() {
		return id_MP_Receita.getReceita();
	}

	public void setReceita(Receita receita) {
		id_MP_Receita.setReceita(receita);
	}

	public Integer getId_MP_Receita_PK() {
		return id_MP_Receita_PK;
	}

	public void setId_MP_Receita_PK(Integer id_MP_Receita_PK) {
		this.id_MP_Receita_PK = id_MP_Receita_PK;
	}
	
	public Double getCustoMP() {
		return custoMP;
	}

	public void setCustoMP(Double custoMP) {
		this.custoMP = custoMP;
		
		this.updateCustoIngrediente();
		
		this.getReceita().updateRendBrutoReceita();
		this.getReceita().updatePerdaReceita();
		this.getReceita().updateCustoReceita();
		this.getReceita().updatePorcenIngredientes();
	}

	public Double getQtIngredienteBruto() {
		return qtIngredienteBruto;
	}

	public void setQtIngredienteBruto(Double qtIngredienteBruto) {
		this.qtIngredienteBruto = qtIngredienteBruto;
		
		this.updateqtIngredienteLiquido();
		
		this.updateCustoIngrediente();
		
		this.getReceita().updateRendBrutoReceita();
		this.getReceita().updatePerdaReceita();
		this.getReceita().updateCustoReceita();
		this.getReceita().updatePorcenIngredientes();
	}

	public Double getPerdaIngrediente() {
		return perdaIngrediente;
	}

	public void setPerdaIngrediente(Double perdaIngrediente) {
		this.perdaIngrediente = perdaIngrediente;
		this.updateqtIngredienteLiquido();
	}

	public Double getQtIngredienteLiquido() {
		return qtIngredienteLiquido;
	}

	public void setQtIngredienteLiquido(Double qtIngredienteLiquido) {
		this.qtIngredienteLiquido = qtIngredienteLiquido;
	}

	public Double getCustoIngrediente() {
		return custoIngrediente;
	}

	public void setCustoIngrediente(Double custoIngrediente) {
		this.custoIngrediente = custoIngrediente;
	}

	public Double getPorcenIngrediente() {
		return porcenIngrediente;
	}

	public void setPorcenIngrediente(Double porcenIngrediente) {
		this.porcenIngrediente = porcenIngrediente;
	}
	
	public void updateqtIngredienteLiquido() {
		
		this.qtIngredienteLiquido = this.qtIngredienteBruto - this.qtIngredienteBruto*((this.perdaIngrediente)/100);
	}
	
	public void updateCustoIngrediente() {
		
		this.custoIngrediente = this.getQtIngredienteBruto()*this.custoMP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_MP_Receita_PK == null) ? 0 : id_MP_Receita_PK.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (id_MP_Receita_PK == null) {
			if (other.id_MP_Receita_PK != null)
				return false;
		} else if (!id_MP_Receita_PK.equals(other.id_MP_Receita_PK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingrediente [id_MP_Receita_PK=" + id_MP_Receita_PK + ", id_MP=" + this.getMP().getIdMP() + ", id_Receita=" + this.getReceita().getIdReceita()
				+ ", qtIngredienteBruto=" + qtIngredienteBruto + ", perdaIngrediente=" + perdaIngrediente
				+ ", qtIngredienteLiquido=" + qtIngredienteLiquido + ", custoMP=" + custoMP + ", custoIngrediente="
				+ custoIngrediente + ", porcenIngrediente=" + porcenIngrediente + "]";
	}

}