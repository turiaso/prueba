package com.inditex.visibilidad.database.domain;

import java.util.Objects;

public class ProductEntity {

    private Long id;
	
    private Long sequence;
    
    public ProductEntity() {}

	public ProductEntity(Long id, Long sequence) {
		super();
		this.id = id;
		this.sequence = sequence;
	}

	public Long getId() {
		return id;
	}

	public Long getSequence() {
		return sequence;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sequence);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(sequence, other.sequence);
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", sequence=" + sequence + "]";
	}
	
    
    
}
