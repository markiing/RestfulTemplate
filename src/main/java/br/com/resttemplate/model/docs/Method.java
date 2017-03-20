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

	private transient Paranamer info = new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));
	private transient java.lang.reflect.Method nativeMethod;
	private String name;
	private String description;
	private String returnType;
	private String dateCreation;
	private String author;
	private List<br.com.resttemplate.model.docs.Parameter> parameters = new ArrayList<br.com.resttemplate.model.docs.Parameter>();
	
	public Method(java.lang.reflect.Method method) {
		this.nativeMethod = method;
		this.name = method.getName();
		this.returnType = method.getReturnType().getCanonicalName();
		
		if(method.isAnnotationPresent(MethodDescription.class)){
			this.description = (String) method.getAnnotation(MethodDescription.class).description();
			this.author = (String) method.getAnnotation(MethodDescription.class).author();
			this.dateCreation =(String) method.getAnnotation(MethodDescription.class).dateCreated();
		}else{
			this.description = "Nenhuma descrição adicionada para este método :(";
			this.author = "Autor inexistente ! Por favor, verifique";
			this.dateCreation = "Data de criação não configurada! Por favor, verifique";
		}
		
		String[] paramName = this.info.lookupParameterNames(method);
		Parameter[] param = method.getParameters();
		
		if(paramName.length == param.length){
			for(int i=0;i<param.length;i++){
				parameters.add(new br.com.resttemplate.model.docs.Parameter(param[i], paramName[i]));
			}
		}
	}

	
}
