package br.com.ngz.rest;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;

public class ApplicationConfiguration extends Application {

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> empty = new HashSet<>();
	public ApplicationConfiguration(){

	     singletons.add(new BaseRest());

	}
	
	@Override
	public Set<Class<?>> getClasses() {
	     return empty;
	}
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}
}
