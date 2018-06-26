package br.com.zeit.interfaces;

import java.util.List;

import br.com.zeit.exceptions.PersistenciaException;

public interface IDAO<T> {

	public boolean insert(T obj) throws PersistenciaException;
	
	public boolean edit(T obj);
	
	public List<T> getAll() throws PersistenciaException;
	
	public T getById(int id) throws PersistenciaException;
	
}
