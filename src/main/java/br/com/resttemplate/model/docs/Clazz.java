package br.com.resttemplate.model.docs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.resttemplate.model.docs.annotations.ClassDescription;

public class Clazz {

	private Class nativeClazz;
	private String description;
	private List<Method> methods = new ArrayList<Method>();
	
	@SuppressWarnings("unchecked")
	public Clazz(@SuppressWarnings("rawtypes") Class c) {
		this.nativeClazz = c;
		//SET CLASS DESCRIPTION
		if(nativeClazz.isAnnotationPresent(ClassDescription.class)){
			ClassDescription classDescription = (ClassDescription) nativeClazz.getAnnotation(ClassDescription.class);
			this.description = classDescription.classDescription();
		}
		
		for(java.lang.reflect.Method m: this.nativeClazz.getDeclaredMethods()){
			this.methods.add(new Method(m));
		}
		
	}
	
	public Class getClazz() {
		return nativeClazz;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<Method> getMethods() {
		return methods;
	}
	
	
	
}
