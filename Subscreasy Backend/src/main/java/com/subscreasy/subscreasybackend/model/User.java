package com.subscreasy.subscreasybackend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	
	@Size(min = 4, message = "*Your user name must have at least 4 characters")
	@NotEmpty(message = "*Please provide a user name")
	@Column(name = "user_name",unique = true)
	private String userName;
   
    @Size(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Column(name = "password")
    private String password;
    
   
    @Size(min = 2, message = "*Your name must have at least 2 characters")
    @NotEmpty(message = "*Please provide your name")
    @Column(name = "name")
    private String name;
    
    @Size(min = 2, message = "*Your surname must have at least 2 characters")
    @NotEmpty(message = "*Please provide your last name")
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "active")
    private Boolean active;
   
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id",nullable = false,updatable = false)
    @JsonIgnore
    private Role role;
    




    public User() {this.active=true;}
    
	public User(
			@Size(min = 4, message = "*Your user name must have at least 4 characters") @NotEmpty(message = "*Please provide a user name") String userName,
			@Size(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
			@Size(min = 2, message = "*Your name must have at least 2 characters") @NotEmpty(message = "*Please provide your name") String name,
			@Size(min = 2, message = "*Your surname must have at least 2 characters") @NotEmpty(message = "*Please provide your last name") String lastName,
			Role role) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.role = role;
		this.active = true;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Role getRole() {
	      return role;
	 }

    /*public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }*/
    public void setRole(Role role) {
    	this.role = role;
    }
    
	public int getId() {
		return id;
	}
}
    