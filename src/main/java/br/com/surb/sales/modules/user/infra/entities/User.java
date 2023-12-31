package br.com.surb.sales.modules.user.infra.entities;

import br.com.surb.sales.modules.role.infra.entities.Role;
import br.com.surb.sales.shared.AppEnums.StatusEnums;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String code;

	private String firstName;

	private String lastName;

	private String birth;

	@Column(unique = true)
	private String email;

	private String password;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	private StatusEnums status;

	/*
	 * Obj dessa form vem junto uma list de roles associação muitos para muitos com
	 * a tb_role usar sempre o set<>
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private final Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(Long userId, String code, String firstName, String lastName, String birth, String email, String password, Instant createdAt, Instant updatedAt, StatusEnums status) {
		this.userId = userId;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}


	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public StatusEnums getStatus() {
		return status;
	}

	public void setStatus(StatusEnums status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	@PrePersist
	public void prePersist() {
		this.code = UUID.randomUUID().toString();
		this.createdAt = Instant.now();
		this.status = StatusEnums.ENABLED;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasRole(String roleName) {
		for (Role role : roles) {
			if (role.getAuthority().equals(roleName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User userModel = (User) o;

		if (!Objects.equals(userId, userModel.userId)) return false;
    return Objects.equals(code, userModel.code);
  }

	@Override
	public int hashCode() {
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (code != null ? code.hashCode() : 0);
		return result;
	}
}
