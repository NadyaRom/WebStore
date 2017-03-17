package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="_user")
public class User implements UserDetails{
	
	private static final long serialVersionUID = -4022893864587230624L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="_name")
	private String username;
	
	private String email;
	
	private String password;
	
	@Enumerated
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Orders> orders;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return username;
	}




	public void setName(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




	public List<Orders> getOrders() {
		return orders;
	}




	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
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
	
	
	

}
