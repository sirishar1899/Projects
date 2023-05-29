package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "login_details")

public class details {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int  id;
    
    String email;

    String password;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

    @Override
    public String toString() {
        return "details [id=" + id + ", email=" + email + ", password=" + password + "]";
    }


    

    
    
}
