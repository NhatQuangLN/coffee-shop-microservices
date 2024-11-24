package com.digital.service_product.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.digital.common_lib.enums.MenuEnum.MenuStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "menu")
public class MenuEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String uuid;
	
	@Column
	private String menuName;
	
	@JoinColumn(referencedColumnName = "uuid", columnDefinition = "store_uuid")
	@ManyToOne(fetch = FetchType.EAGER)
	private StoreEntity store;
	
	@Column
	private String createdBy;
	
	@Column
	@Enumerated(EnumType.STRING)
	private MenuStatus status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	private Set<MenuDetailEntity> menuDetails = new HashSet<>();
	
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
