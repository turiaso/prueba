package com.inditex.visibilidad.database.domain;

import java.util.Objects;

public class SizeEntity {

    private Long id;
	
    private Long productId;
    
    private Boolean backSoon;
    
    private Boolean special;
	
    
    public SizeEntity() {}


	public SizeEntity(Long id, Long productId, Boolean backSoon, Boolean special) {
		super();
		this.id = id;
		this.productId = productId;
		this.backSoon = backSoon;
		this.special = special;
	}


	public Long getId() {
		return id;
	}


	public Long getProductId() {
		return productId;
	}


	public Boolean getBackSoon() {
		return backSoon;
	}


	public Boolean getSpecial() {
		return special;
	}


	@Override
	public int hashCode() {
		return Objects.hash(backSoon, id, productId, special);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeEntity other = (SizeEntity) obj;
		return Objects.equals(backSoon, other.backSoon) && Objects.equals(id, other.id)
				&& Objects.equals(productId, other.productId) && Objects.equals(special, other.special);
	}


	@Override
	public String toString() {
		return "SizeEntity [id=" + id + ", productId=" + productId + ", backSoon=" + backSoon + ", special=" + special
				+ "]";
	}

    
    
}
