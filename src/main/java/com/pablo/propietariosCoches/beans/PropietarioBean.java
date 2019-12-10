package com.pablo.propietariosCoches.beans;

public class PropietarioBean {

	
	private String nombre, email, modelo, mensaje, coche;
	private Integer id, edad;
	private boolean carnet;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public boolean isCarnet() {
		return carnet;
	}
	public void setCarnet(boolean carnet) {
		this.carnet = carnet;
	}
	public String getCoche() {
		return coche;
	}
	public void setCoche(String coche) {
		this.coche = coche;
	}
	@Override
	public String toString() {
		return "PropietarioBean [nombre=" + nombre + ", email=" + email + ", modelo=" + modelo + ", mensaje=" + mensaje
				+ ", coche=" + coche + ", id=" + id + ", edad=" + edad + ", carnet=" + carnet + "]";
	}
	
	
}
