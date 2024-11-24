package com.digital.service_counter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@JoinColumn(columnDefinition = "order_uuid", referencedColumnName = "uuid")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrderEntity order;
	
	@Column
	private String productUuid;

	@Column
	private String productCode;
	
	@Column
	private String productName;
	
	@Column
	private Double price;
	
	@Column
	private Integer quantity;
	
	@Column
	public LocalDateTime createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

}
