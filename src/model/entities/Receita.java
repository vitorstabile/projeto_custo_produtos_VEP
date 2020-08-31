package model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idReceita;
	private String descricaoReceita;
	private Double rendLiqReceita;
	private Double rendBrutoReceita;
	private Double perdaReceita;
	private Double custoReceita;
	private Date dataReceita;
	
	private List<Ingrediente> ingredientes = new ArrayList<>();
	
	public Receita() {
	}


	public Receita(Integer idReceita, String descricaoReceita, Double rendLiqReceita) {
		this.idReceita = idReceita;
		this.descricaoReceita = descricaoReceita;
		this.rendLiqReceita = rendLiqReceita;
		this.rendBrutoReceita = null;
		this.perdaReceita = null;
		this.custoReceita = null;
		this.dataReceita = new Date();
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(date);
	}


	public Integer getIdReceita() {
		return idReceita;
	}


	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}


	public String getDescricaoReceita() {
		return descricaoReceita;
	}


	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}


	public Double getRendLiqReceita() {
		return rendLiqReceita;
	}


	public void setRendLiqReceita(Double rendLiqReceita) {
		this.rendLiqReceita = rendLiqReceita;
		
		updateRendBrutoReceita();
		updatePerdaReceita();
		updateCustoReceita();
		updatePorcenIngredientes();
	}


	public Double getRendBrutoReceita() {
		return rendBrutoReceita;
	}


	public void setRendBrutoReceita(Double rendBrutoReceita) {
		this.rendBrutoReceita = rendBrutoReceita;
	}


	public Double getPerdaReceita() {
		return perdaReceita;
	}


	public void setPerdaReceita(Double perdaReceita) {
		this.perdaReceita = perdaReceita;
	}


	public Double getCustoReceita() {
		return custoReceita;
	}


	public void setCustoReceita(Double custoReceita) {
		this.custoReceita = custoReceita;
	}


	public Date getDataReceita() {
		return dataReceita;
	}


	public void setDataReceita(Date dataReceita) {
		this.dataReceita = dataReceita;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void addIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
		updateRendBrutoReceita();
		updatePerdaReceita();
		updateCustoReceita();
		updatePorcenIngredientes();
	}

	public void removeIngrediente(Ingrediente ingrediente) {
		this.ingredientes.remove(ingrediente);
		updateRendBrutoReceita();
		updatePerdaReceita();
		updateCustoReceita();
		updatePorcenIngredientes();
	}

	public void updateRendBrutoReceita() {

		double soma = 0;

		for (Ingrediente ingrediente : ingredientes) {
			soma = soma + ingrediente.getQtIngredienteBruto();
		}
		this.setRendBrutoReceita(soma);
	}

	public void updatePerdaReceita() {

		double perda = ((this.getRendBrutoReceita() - this.getRendLiqReceita()) / (this.getRendBrutoReceita()))* 100;

		this.setPerdaReceita(perda);
	}
	
	public void updateCustoReceita() {
		
		double soma = 0;

		for (Ingrediente ingrediente : ingredientes) {
			soma = soma + ingrediente.getCustoIngrediente();
		}
		
		double custo = soma / this.getRendLiqReceita();
		
		this.setCustoReceita(custo);
		
	}
	
	public void updatePorcenIngredientes() {

		for (Ingrediente ingrediente : ingredientes) {
			ingrediente.setPorcenIngrediente((ingrediente.getQtIngredienteBruto()/this.getRendBrutoReceita())*100);
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReceita == null) ? 0 : idReceita.hashCode());
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
		Receita other = (Receita) obj;
		if (idReceita == null) {
			if (other.idReceita != null)
				return false;
		} else if (!idReceita.equals(other.idReceita))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Receita [idReceita=" + idReceita + ", descricaoReceita=" + descricaoReceita + ", rendLiqReceita="
				+ rendLiqReceita + ", rendBrutoReceita=" + rendBrutoReceita + ", perdaReceita=" + perdaReceita
				+ ", custoReceita=" + custoReceita + ", dataReceita=" + formatDate(dataReceita) + ", ingredientes=" + ingredientes
				+ "]";
	}
}
