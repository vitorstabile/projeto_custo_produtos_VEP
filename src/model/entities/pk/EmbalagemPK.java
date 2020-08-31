package model.entities.pk;

import java.io.Serializable;

import model.entities.MP;
import model.entities.Produto;

public class EmbalagemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private MP mp;
	private Produto produto;
	
	public MP getMp() {
		return mp;
	}
	
	public void setMp(MP mp) {
		this.mp = mp;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mp == null) ? 0 : mp.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		EmbalagemPK other = (EmbalagemPK) obj;
		if (mp == null) {
			if (other.mp != null)
				return false;
		} else if (!mp.equals(other.mp))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	
}
