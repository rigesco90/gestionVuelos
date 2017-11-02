package com.gfinanciera.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gfinanciera.dao.GenericDAO;
import com.gfinanciera.util.dao.GQuery;

public class GenericDAOJPAImpl implements GenericDAO {

	@PersistenceContext(unitName = "GestionVuelosPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<?> clazz) {
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz order by tz.id";
		final Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<?> clazz, Object gquery) {
		GQuery query = (GQuery) gquery;
		Log.log(Level.INFO, "DBGMSG: GQUERY: " + query.getJPQL());
		final Query q = em.createQuery(query.getJPQL());
		for (int i = 0; i < query.getParams().size(); i++) {
			q.setParameter(query.getParams().get(i), query.getComparables().get(i));
		}

		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T find(Object gquery) {
		GQuery query = (GQuery) gquery;
		Log.log(Level.INFO, "DBGMSG: GQUERY: " + query.getJPQL());
		try {
			final Query q = em.createQuery(query.getJPQL());
			for (int i = 0; i < query.getParams().size(); i++) {
				q.setParameter(query.getParams().get(i), query.getComparables().get(i));
			}
			return (T) q.getSingleResult();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener OBJECT en: find, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAllJoinFetch(Class<?> clazz, String... joins) {
		String strjoins = "";
		for (String join : joins) {
			strjoins += "JOIN FETCH tz." + join + " ";
		}
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz " + strjoins + " order by tz.id";
		final Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public <T> T edit(T arg0) {
		return em.merge(arg0);
	}

	@Override
	public void create(Object arg0) {
		em.persist(arg0);
	}

	@Override
	public <T> T createReturnObject(T arg0) {
		em.persist(arg0);
		this.em.flush();
		this.em.refresh(arg0);
		return arg0;
	}

	@Override
	public void delete(Class<?> type, Object id) {
		Object ref = this.em.getReference(type, id);
		this.em.remove(ref);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAllExceptId(Class<T> clazz, Object id) {
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz " + "WHERE tz.id != " + id;
		final Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	private static final Logger Log = Logger.getLogger(GenericDAOJPAImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchObjectById(Class<T> clazz, int id) {
		final String jpql = "SELECT tz FROM " + clazz.getSimpleName() + " tz " + "WHERE tz.id = " + id;
		final Query query = em.createQuery(jpql);
		return (T) query.getSingleResult();
	}

	@Override
	public <T> Long Count(Class<T> claseEntidad) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT COUNT(myEntity) FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			Query query = this.em.createQuery(jpql.toString());
			return (Long) query.getSingleResult();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener la cantidad en Count, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchLast(Class<T> claseEntidad) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT MAX(miEntidad) FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" miEntidad ");
			Query query = this.em.createQuery(jpql.toString());
			return (T) query.getSingleResult();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener el ultimo elemento en searchLast, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String namedQueryName) {
		try {
			Query query = this.em.createNamedQuery(namedQueryName);
			return (List) query.getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String namedQueryName, Map parameters) {
		try {
			return findWithNamedQuery(namedQueryName, parameters, 0);
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Parametros, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String queryName, int resultLimit) {
		try {
			Query query = this.em.createNamedQuery(queryName);
			return (List) query.setMaxResults(resultLimit).getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Limite, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public List findByNativeQuery(String sql) {
		try {
			Query query = this.em.createNativeQuery(sql);
			List<Object> list = new ArrayList<>();
			return list = query.getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findByNativeQuery, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit) {
		try {
			Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
			Query query = this.em.createNamedQuery(namedQueryName);
			if (resultLimit > 0) {
				query.setMaxResults(resultLimit);
			}
			for (Map.Entry<String, Object> entry : rawParameters) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			return (List) query.getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Parametros y Limite, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findWithNamedQuery(String namedQueryName, Map parameters, int start, int end) {
		try {
			Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
			Query query = this.em.createNamedQuery(namedQueryName);
			for (Map.Entry<String, Object> entry : rawParameters) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			query.setMaxResults(end - start);
			query.setFirstResult(start);
			return (List) query.getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Parametros y Limite, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findWithNamedQuery(String namedQueryName, int start, int end) {
		try {
			Query query = this.em.createNamedQuery(namedQueryName);
			query.setMaxResults(end - start);
			query.setFirstResult(start);
			return (List) query.getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener elementos en findWithNamedQuery con Limite para paginado, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> searchAllWithOneArg(Class<T> claseEntidad, String parametro, String valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = '" + valor + "'");
			Query query = this.em.createQuery(jpql.toString());
			return (List<T>) query.getResultList();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Buscar todos los registros en searchAll, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchObjectWithOneArg(Class<T> claseEntidad, String parametro, String valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = '" + valor + "'");
			Query query = this.em.createQuery(jpql.toString());
			return (T) query.getSingleResult();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Buscar todos los registros en searchAll, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchElementWithOneArg(Class<T> claseEntidad, String parametro, String valor) {
		StringBuilder jpql = new StringBuilder();
		Log.info(" >>>>>>>>>>>>>>>>>>>>> Parametro  " + parametro);
		Log.info(" >>>>>>>>>>>>>>>>>>>>> Valor  " + valor);
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = '" + valor + " '");
			Query query = this.em.createQuery(jpql.toString());
			List<T> results = query.getResultList();
			if (results.isEmpty()) {
				return null; // handle no-results case
			} else {
				return (T) results.get(0);
			}
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Buscar el Elemento en searchElementWithOneArg el error es el siguiente: "
							+ e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchElementWithOneArgInteger(Class<T> claseEntidad, String parametro, int valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = " + valor + " ");
			Query query = this.em.createQuery(jpql.toString());
			return (T) query.getSingleResult();
		} catch (Exception e) {
			Log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>    " + valor
					+ "    Hubo un error al Buscar el Elemento en searchElementWithOneArg el error es el siguiente: "
					+ e.getMessage());

			e.printStackTrace(System.out);
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T searchElementWithOneArgLong(Class<T> claseEntidad, String parametro, long valor) {
		StringBuilder jpql = new StringBuilder();
		try {
			jpql.append("SELECT myEntity FROM ");
			jpql.append(claseEntidad.getSimpleName());
			jpql.append(" myEntity ");
			jpql.append(" WHERE " + parametro + " = " + valor + " ");
			Query query = this.em.createQuery(jpql.toString());
			// return (T) query.getSingleResult();
			List<T> results = query.getResultList();
			if (results.isEmpty()) {
				return null; // handle no-results case
			} else {
				return (T) results.get(0);
			}
		} catch (Exception e) {
			Log.info("  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>    " + valor
					+ "    Hubo un error al Buscar el Elemento en searchElementWithOneArg el error es el siguiente: "
					+ e.getMessage());

			e.printStackTrace(System.out);
			return null;
		}
	}

	@Override
	public Long countTotalRecord(String namedQueryName) {
		try {
			Query query = em.createNamedQuery(namedQueryName);
			return (Long) query.getSingleResult();
		} catch (Exception e) {
			Log.info(
					"  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Hubo un error al Obtener el Total de elemento en countTotalRecord, el error es el siguiente: "
							+ e.getMessage());
			return null;
		}
	}
}
