package br.com.surb.sales.modules.role.infra.entities;

import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.shared.AppEnums.StatusEnums;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String code;
	@Column(unique = true)
	private String authority;
	private StatusEnums status;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	@ManyToMany(mappedBy = "roles")
	private final List<User> users = new ArrayList<>();


	public Role() {
	}

	public Role(Long roleId, String code, String authority, StatusEnums status, Instant createdAt, Instant updatedAt) {
		this.roleId = roleId;
		this.code = code;
		this.authority = authority;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public StatusEnums getStatus() {
		return status;
	}

	public void setStatus(StatusEnums status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public List<User> getUsers() {
		return users;
	}

	@PrePersist
	public void preCreated() {
		code = UUID.randomUUID().toString();
		createdAt = Instant.now();
		status = StatusEnums.ENABLED;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

}
