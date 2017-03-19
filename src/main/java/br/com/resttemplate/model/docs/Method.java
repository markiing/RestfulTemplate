package br.com.resttemplate.model.docs;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import br.com.resttemplate.model.docs.annotations.MethodDescription;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

public class Method {

	private Paranamer info = new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));
	private java.lang.reflect.Method nativeMethod;
	private String description;
	private List<br.com.resttemplate.model.docs.Parameter> parameters = new ArrayList<br.com.resttemplate.model.docs.Parameter>();
	
	public Method(java.lang.reflect.Method method) {
		this.nativeMethod = method;
		//SET METHOD DESCRIPTION
		if(method.isAnnotationPresent(MethodDescription.class)){
			this.description = (String) method.getAnnotation(MethodDescription.class).description();
		}
		
		String[] paramName = this.info.lookupParameterNames(method);
		Parameter[] param = method.getParameters();
		
		if(paramName.length == param.length){
			for(int i=0;i<param.length;i++){
				parameters.add(new br.com.resttemplate.model.docs.Parameter(param[i], paramName[i]));
			}
		}
	}

	public java.lang.reflect.Method getMethod() {
		return nativeMethod;
	}
	
	public String getDescription() {
		return description;
	}

	public List<br.com.resttemplate.model.docs.Parameter> getParameters() {
		return parameters;
	}
	
}
