package com.example.demo.modelo;








import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="paterno")
	private String aPaterno;
	
	@Column(name="materno")
	private String aMaterno;

	@Column(name="fecha_nacimiento")
	private String fechaNacimiento;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="emal")
	private String emal;
	
	@Column(name="sexo")
	private char sexo;
	
	
	public Cliente() {
		
		
	}


	public Cliente(long id, String nombres, String aPaterno, String aMaterno, String fechaNacimiento, String direccion,
			String emal, char sexo) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.emal = emal;
		this.sexo = sexo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getaPaterno() {
		return aPaterno;
	}


	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}


	public String getaMaterno() {
		return aMaterno;
	}


	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmal() {
		return emal;
	}


	public void setEmal(String emal) {
		this.emal = emal;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombres=" + nombres + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno
				+ ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", emal=" + emal + ", sexo="
				+ sexo + "]";
	}
	
	
}



