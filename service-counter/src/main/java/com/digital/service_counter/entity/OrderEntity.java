package com.digital.service_counter.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String uuid;

	@Column
	private String storeUuid;

	@Column
	@JoinColumn(referencedColumnName = "uuid", columnDefinition = "counter_uuid")
	@ManyToOne(fetch = FetchType.EAGER)
	private CounterEntity counter;
	
	@Column
	private Double totalPrice;

	@Column
	public String createdBy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@JoinColumn(name = "uuid")
	private Set<OrderDetailEntity> orderDetails = new HashSet<>();

	@Column
	public LocalDateTime createdAt;

	@Column
	public LocalDateTime updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

}
