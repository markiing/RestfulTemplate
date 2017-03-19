package br.com.resttemplate.controller;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import br.com.resttemplate.model.docs.Clazz;
import br.com.resttemplate.model.docs.annotations.ClassDescription;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

@Controller
@RequestMapping(value="/doc")
@ClassDescription(classAuthor="Marcus Cartágenes", classDescription="Classe responsável por documentação de Serviços")
public class DocsController {

	@Autowired
	private ListableBeanFactory beanFactory;
	
	@RequestMapping(value="/")
	public void show(){
		List<Clazz> clazz = new ArrayList<Clazz>();
		Clazz c;
		
		for(Map.Entry<String, Object> obj: beanFactory.getBeansWithAnnotation(RestController.class).entrySet()){
				c = new Clazz(obj.getValue().getClass());
				clazz.add(c);
		}
		
		System.out.println(clazz);
		
	}
}
