package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {

	private Integer idProduto;
	private String descricaoProduto;
	private Double baseCalcProduto;
	private Double gramaturaProduto;
	private Double rendBrutoProduto;
	private Double custoProduto;
	private Date dataProduto;
	
	
	
	public Produto() {
	}

	public Produto(Integer idProduto, String descricaoProduto, Double baseCalcProduto) {
		this.idProduto = idProduto;
		this.descricaoProduto = descricaoProduto;
		this.baseCalcProduto = baseCalcProduto;
		this.gramaturaProduto = null;
		this.rendBrutoProduto = null;
		this.custoProduto = null;
		this.dataProduto = new Date();
		
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(date);
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getBaseCalcProduto() {
		return baseCalcProduto;
	}

	public void setBaseCalcProduto(Double baseCalcProduto) {
		this.baseCalcProduto = baseCalcProduto;
	}

	public Double getGramaturaProduto() {
		return gramaturaProduto;
	}

	public void setGramaturaProduto(Double gramaturaProduto) {
		this.gramaturaProduto = gramaturaProduto;
	}

	public Double getRendBrutoProduto() {
		return rendBrutoProduto;
	}

	public void setRendBrutoProduto(Double rendBrutoProduto) {
		this.rendBrutoProduto = rendBrutoProduto;
	}

	public Double getCustoProduto() {
		return custoProduto;
	}

	public void setCustoProduto(Double custoProduto) {
		this.custoProduto = custoProduto;
	}

	public Date getDataProduto() {
		return dataProduto;
	}

	public void setDataProduto(Date dataProduto) {
		this.dataProduto = dataProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricaoProduto=" + descricaoProduto + ", baseCalcProduto="
				+ baseCalcProduto + ", gramaturaProduto=" + gramaturaProduto + ", rendBrutoProduto=" + rendBrutoProduto
				+ ", custoProduto=" + custoProduto + ", dataProduto=" + formatDate(dataProduto) + "]";
	}
	
}
