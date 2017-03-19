package br.com.resttemplate.model.docs;

import br.com.resttemplate.model.docs.annotations.ParamDescription;


public class Parameter {

	private java.lang.reflect.Parameter nativeParameter;
	private String name;
	private String description;
	
	public Parameter(java.lang.reflect.Parameter p, String name) {
		this.nativeParameter = p;
		this.name = name;
		
		if(p.isAnnotationPresent(ParamDescription.class)){
			this.description = (String) p.getAnnotation(ParamDescription.class).description();
		}
	}
	
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	
}
