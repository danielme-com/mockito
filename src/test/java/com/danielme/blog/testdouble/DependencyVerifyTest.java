package com.danielme.blog.testdouble;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class DependencyVerifyTest {

	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	private Dependency dependency;	
	
	@Test
	public void testSimpleVerify() {	
		//nunca se ha ejecutado
		verify(dependency, never()).getClassNameUpperCase();
		
		dependency.getClassNameUpperCase();
		//exactamente una vez
		verify(dependency, times(1)).getClassNameUpperCase();
		//como mínimo una vez
		verify(dependency, atLeast(1)).getClassNameUpperCase();
		
		dependency.getClassNameUpperCase();
		//como máximo 2 veces
		verify(dependency, atMost(2)).getClassNameUpperCase();
	}
	
	@Test
	public void testParameters() {			
		dependency.addTwo(3);
		//una vez con el parámetro 3
		verify(dependency, times(1)).addTwo(3);
		
		dependency.addTwo(4);
		//dos veces con cualquier parámetro
		verify(dependency, times(2)).addTwo(anyInt());
	}	
	
}
