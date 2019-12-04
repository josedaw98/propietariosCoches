package com.pablo.propietariosCoches.listas;

import java.util.ArrayList;
import java.util.List;

import com.pablo.propietariosCoches.beans.CocheBean;


public class ListaCoches {

	
	/*
	 * 
	 * SINGLENTON PURO EN EL QUE CREAMOS UN ARRAY PRIVADO DE NUESTRO BEAN, E INSTANCIAMOS NUESTRA PROPIA CLASE
	 * LUEGO TENEMOS EL CONSTRUCTOR CON LA LISTA, Y UN METODO GETDATOS() QUE NOS DEVUELVE LA LISTA.
	 * 
	 * */
	
	
	private ArrayList<CocheBean> lista = null;
	private static ListaCoches listaCoches = null;

	
	private ListaCoches() {
		
		lista = new ArrayList();
		
	}
	
	public List<CocheBean> getDatos() {
		
		return lista;
	}
	
	
	/*
	 * 
	 * CREACIONES DE ID Y BÚSQUEDAS POR ID DE OBJETOS
	 * 
	 * */
	
	
	/**
	 * Este método busca un objeto mediante el id
	 * @param idBuscado
	 * @return devuelve un int diciendo el indice
	 */
	private int busquedaPorId(int idBuscado) {
		
		// Iniciamos con una bandera indicando que no está encontrado
		boolean encontrado = false;
		
		int indice = 0;
		
		// Mientras que no se encuentra y no llego al final
		while((!encontrado) && (indice<lista.size())) {
			
			// Lo voy buscando
			if(lista.get(indice).getId() == idBuscado) {
				
				encontrado = true;
			}
			// Y si no aparece, avanzo
			else indice ++;
		}
		if(encontrado) return indice; else return -1;
	}
	
	
	/**
	 * Devuelve un coche en concreto, 
	 * @param id
	 * @return si lo encuentra devuelve el objeto entero
	 */
	public CocheBean getAutor(int idBuscado) {
		
		int dondeEsta = busquedaPorId(idBuscado);
		if(dondeEsta>=0) {
			
			return lista.get(dondeEsta);
		}
		else return null;
	}
	
	/**
	 * Este método genera un id que no sea repetido
	 * @return el id que autogenero
	 */
	private int getIdNoRepetido() {
		
		// Numero entre 1 y 100
		int numero = (int) (Math.random()*100+1);	
		
		// Busco hasta que no lo encuentro
		while (busquedaPorId(numero) != -1) {
			
			numero = (int) (Math.random()*100+1);
		}
		
		return numero;
	}
	
	
	/*
	 * 
	 * MÉTODOS DE AÑADIR, EDITAR, BORRAR
	 * 
	 * */
	
	
	/**
	 * Añade un coche a la lista (aka Modelo)
	 * 
	 * @param coche
	 */
	public void addCoche(CocheBean coche) {
		
		coche.setId(getIdNoRepetido());
		lista.add(coche);
	}
	
	/**
	 * Actualiza un coche buscando primero su posicion en la lista
	 * 
	 * @param coche
	 */
	public void updateCoche(CocheBean coche) {
		
		int posicion = busquedaPorId(coche.getId());
		lista.set(posicion, coche);
	}
	
	
	/**
	 * Borra un objeto coche
	 * @param idBuscado
	 */
	public void delCoche(int idBuscado) {
		
		// Pregunto que si existe el ID
		int dondeEsta = busquedaPorId(idBuscado);
		
		// Si lo encuentra, lo borra
		if(dondeEsta>=0) {
			
			lista.remove(dondeEsta);
		}
	}
	
	
	/*
	 * 
	 * PEDIMOS EL SINGLENTON
	 * 
	 * */
	
	
	/**
	 * Este es el método público con el que llamamos al privado para poder trabajar con él
	 * @return
	 */
	public static ListaCoches getLista() {
		
		if(listaCoches==null) {
			
			listaCoches = new ListaCoches();
		}
		
		return listaCoches;
	}
	
	
}
