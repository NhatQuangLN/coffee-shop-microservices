package com.digital.service_counter.entity;

import java.time.LocalDateTime;

import com.digital.common_lib.enums.CounterEnum.CounterStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "counter")
public class CounterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String uuid;
	
	@Column
	private String counterName;
	
	@Column
	private Integer maxQueueNo;
	
	@Column
	@Enumerated(EnumType.STRING)
	private CounterStatus status;

	private String storeUuid;

	@Column
	public LocalDateTime createdAt;
	
	@Column
	public String createdBy;

	@Column
	public LocalDateTime updatedAt;
	
	@Column
	public String updatedBy;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
