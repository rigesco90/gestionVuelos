package com.gfinanciera.BOImplements;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gfinanciera.BO.GenericBO;
import com.gfinanciera.dao.GenericDAO;

@Stateless
public class GenericEJB implements GenericBO{

	@Inject
	private GenericDAO genericDAO;

	@Override
	 public <T> List<T> findAll(Class<T> clazz) {
	  return genericDAO.findAll(clazz);
	 }
	
	@Override
	 public <T> List<T> findAll(Class<T> clazz,Object query) { 
	  return genericDAO.findAll(clazz,query);
	 }
	
	@Override
	 public <T> T find(Object query) {
	  return genericDAO.find(query);
	 }
	
	@Override
	public <T> List<T> findAllJoinFetch(Class<?> clazz,String...  joins){
		return genericDAO.findAllJoinFetch(clazz, joins);
	}

	@Override
	public <T> T edit(T arg0) {
		return genericDAO.edit(arg0);
	}

	@Override
	public void create(Object arg0) {
		genericDAO.create(arg0);		
	}

	@Override
	public <T> void delete(Class<T> type, Object id) {
		genericDAO.delete(type, id);		
	}

	@Override
	public <T> List<T> findAllExceptId(Class<T> clazz, Object id) {		
		return genericDAO.findAllExceptId(clazz, id);
	}

	@Override
	public <T> T searchObjectById(Class<T> clazz, int id) {		
		return genericDAO.searchObjectById(clazz, id);
	}

	@Override
	public <T> T createReturnObject(T arg0) {		
		return genericDAO.createReturnObject(arg0);
	}

	@Override
	public <T> Long Count(Class<T> claseEntidad) {
		return genericDAO.Count(claseEntidad);
	}

	@Override
	public <T> T searchLast(Class<T> claseEntidad) {
		return genericDAO.searchLast(claseEntidad);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findWithNamedQuery(String namedQueryName) {		
		return genericDAO.findWithNamedQuery(namedQueryName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<?, ?> parameters) {		
		return genericDAO.findWithNamedQuery(namedQueryName, parameters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findWithNamedQuery(String queryName, int resultLimit) {
		return genericDAO.findWithNamedQuery(queryName, resultLimit);
	}

	@Override
	public <T> List<T> findByNativeQuery(String sql) {
		return genericDAO.findByNativeQuery(sql);
	}

	@Override
	public Long countTotalRecord(String namedQueryName) {
		return genericDAO.countTotalRecord(namedQueryName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<?, ?> parameters, int resultLimit) {
		return genericDAO.findWithNamedQuery(namedQueryName, parameters, resultLimit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<?, ?> parameters, int start, int end) {
		return genericDAO.findWithNamedQuery(namedQueryName, parameters, start, end);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findWithNamedQuery(String namedQueryName, int start, int end) {
		return genericDAO.findWithNamedQuery(namedQueryName, start, end);
	}

	@Override
	public <T> List<T> searchAllWithOneArg(Class<T> claseEntidad, String parametro, String valor) {
		return genericDAO.searchAllWithOneArg(claseEntidad, parametro, valor);
	}

	@Override
	public <T> T searchElementWithOneArg(Class<T> claseEntidad, String parametro, String valor) {
		return genericDAO.searchElementWithOneArg(claseEntidad, parametro, valor);
	}

	@Override
	public <T> T searchElementWithOneArgInteger(Class<T> claseEntidad, String parametro, int valor) {
		return genericDAO.searchElementWithOneArgInteger(claseEntidad, parametro, valor);
	}

	@Override
	public <T> T searchElementWithOneArgLong(Class<T> claseEntidad, String parametro, long valor) {
		return genericDAO.searchElementWithOneArgLong(claseEntidad, parametro, valor);
	}
	
	public <T> T searchObjectWithOneArg(Class<T> claseEntidad, String parametro, String valor){
		return genericDAO.searchObjectWithOneArg(claseEntidad, parametro, valor);
	}
}
