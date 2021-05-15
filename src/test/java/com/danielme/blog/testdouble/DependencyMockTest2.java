package com.danielme.blog.testdouble;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.danielme.blog.testdouble.SubDependency;
public class DependencyMockTest2 {

	@Mock
	private SubDependency subDependency;
	@InjectMocks
	private Dependency dependency;

	@Before
	public void setupMock() {
		MockitoAnnotations.openMocks(this);
		//dependency = new Dependency(subDependency);
	}

	@Test
	public void testSubdependency() {
		when(subDependency.getClassName()).thenReturn("hi there 2");		
		assertEquals("hi there 2", dependency.getSubdepedencyClassName());
	}	
	
}