package br.com.ml.xmen.model.dao.entities;

import javax.persistence.Column;
import javax.persistence.Id;

@javax.persistence.Entity(name = Statis.TABLE)
public class Statis {
	public static final String TABLE = "STATIS";
	
	public Statis() {
		super();
	}

	public Statis(Integer id, Integer count) {
		super();
		this.id = id;
		this.count = count;
	}


	
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "COUNT")
	private Integer count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Statis other = (Statis) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
