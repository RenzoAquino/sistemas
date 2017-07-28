package com.sgv.core.dao.domain;

import java.io.Serializable;

public class Company implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private String website;
    
    public Company(){
    }
    public Company(String name, String website){
    	this.name = name;
    	this.website = website;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}
