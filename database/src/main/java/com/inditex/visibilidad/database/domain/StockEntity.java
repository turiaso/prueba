package com.inditex.visibilidad.database.domain;

import java.util.Objects;

public class StockEntity {

    private Long sizeId;
	
    private Long quantity;
	
    public StockEntity() {}

	public StockEntity(Long sizeId, Long quantity) {
		super();
		this.sizeId = sizeId;
		this.quantity = quantity;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public Long getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(quantity, sizeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockEntity other = (StockEntity) obj;
		return Objects.equals(quantity, other.quantity) && Objects.equals(sizeId, other.sizeId);
	}

	@Override
	public String toString() {
		return "StockEntity [sizeId=" + sizeId + ", quantity=" + quantity + "]";
	}

    
}
