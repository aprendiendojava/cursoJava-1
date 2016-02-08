package com.wpsnetwork.dao.interfaces;

import java.util.List;

public interface Dao <T>{
	
	public T getId(int id) ;
	
	public void insert (T obj) ;
	
	public void update (T obj) ;
	
	public void delete (T obj) ;
	
	public List<T> getAll () ;
	
}
