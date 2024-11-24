package com.digital.service_counter.entity;

import java.time.LocalDate;
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
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_running_no")
public class OrderRunningNo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private Long runningNo;
	
	@Column
	private String storeUuid;

	@Column
	@JoinColumn(referencedColumnName = "uuid", columnDefinition = "counter_uuid")
	@ManyToOne(fetch = FetchType.EAGER)
	private CounterEntity counter;
	
	@Column
	private LocalDate runningDate;
	
	@Version
	private Integer version;
	
	@Column
	public LocalDateTime createdAt;
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}
}
