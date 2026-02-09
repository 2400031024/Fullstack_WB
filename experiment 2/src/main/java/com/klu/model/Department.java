package com.klu.model;
import javax.persistence.*;
@Entity
@Table(name="dept")

public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptid;
	private String deptname;

public void setDeptId(int deptid) {
	this.deptid= deptid;
}
public int getDeptId() {
	return deptid;
}
public void setDeptName(String deptname) {
	this.deptname=deptname;
}
public String getDeptName() {
	return deptname;
}

}
