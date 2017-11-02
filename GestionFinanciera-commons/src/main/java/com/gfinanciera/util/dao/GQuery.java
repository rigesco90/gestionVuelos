package com.gfinanciera.util.dao;

import java.util.ArrayList;
import java.util.List;

public class GQuery {

	private List<String> entities = new ArrayList<String>();
	private List<String> conditions = new ArrayList<String>();
	private List<String> params = new ArrayList<String>();
	private List<Object> comparables = new ArrayList<Object>();
	private String orderby = "";
	private String alias;
	private String distinct;

	

	public GQuery(String c) {
		String[] s = c.split(" ");
		distinct= "";
		if(s.length > 1){
			alias = s[1];
		}else{
			alias = "_"+c.toLowerCase()+"_";
		}
		
		entities.add(s[0]+" "+alias);
	}

	public GQuery Distinct(String d){
		this.distinct = d;
		return this;
	}
	
	public GQuery Join(String j) {
		entities.add("JOIN " + j);
		return this;
	}
	
	public GQuery LeftJoin(String j) {
		entities.add("LEFT JOIN " + j);
		return this;
	}
	
	public GQuery RghtJoin(String j) {
		entities.add("RIGHT JOIN " + j);
		return this;
	}

	public GQuery Fetch(String j) {
		entities.add("JOIN FETCH " + j);
		return this;
	}
	
	public GQuery LeftFetch(String j) {
		entities.add("LEFT JOIN FETCH " + j);
		return this;
	}
	
	public GQuery RightFetch(String j) {
		entities.add("RIGHT JOIN FETCH " + j);
		return this;
	}

	public GQuery Where(String attribute, String operator, Object comparable) {
		String param_name = "p_" + attribute.replace('.', '_');
		conditions.add(attribute + " " + operator + " :" + param_name + " ");
		params.add(param_name);
		comparables.add(comparable);
		return this;
	}

	public GQuery And() {
		int last = conditions.size() - 1;
		conditions.set(last, conditions.get(last) + " AND ");
		return this;
	}

	public GQuery Or() {
		int last = conditions.size() - 1;
		conditions.set(last, conditions.get(last) + " OR ");
		return this;
	}

	public GQuery OrderBy(String attribute) {
		this.orderby = attribute;
		return this;
	}

	public String getJPQL() {
		String jpql = "SELECT " + (!distinct.equals("")?"distinct "+distinct:alias) + " FROM ";
		for (String e : entities) {
			jpql += e + " ";
		}
		if (!conditions.isEmpty()) {
			jpql += "WHERE ";
			for (String c : conditions) {
				jpql += c + " ";
			}
		}

		if (!orderby.equals("")) {
			jpql += " ORDER BY " + orderby;
		}
		return jpql;
	}

	@Override
	public String toString() {
		return this.getJPQL();
	}

	public List<String> getParams() {
		return params;
	}

	public List<Object> getComparables() {
		return comparables;
	}
}
