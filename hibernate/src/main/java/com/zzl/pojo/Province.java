package com.zzl.pojo;

import java.util.HashSet;
import java.util.Set;

public class Province {
	private int id ;
	private String pname ;
	private Set<City> scity=new HashSet<City>();
	
	
	
	public Set<City> getScity() {
		return scity;
	}
	public void setScity(Set<City> scity) {
		this.scity = scity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	

}
