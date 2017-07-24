package com.danielme.blog.testdouble;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

public class DependencyMockTest {

	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	private Dependency dependency;
	

	@Before
	public void setupMock() {
		//MockitoAnnotations.initMocks(this);
		//without annotations using the static org.mockito.Mockito.mock method
		//dependency = mock(Dependency.class);
	}
	
	@Test
	public void testDummy() {
		assertNull(dependency.getClassName());
		assertNull(dependency.getClassNameUpperCase());
		assertNull(dependency.getSubdepedencyClassName());		
	}

	@Test
	public void testDependency() {		
		when(dependency.getClassName()).thenReturn("hi there");
		assertEquals("hi there", dependency.getClassName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {		
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	}
	
	@Test
	public void testAnswer() {		
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {

			public Integer answer(InvocationOnMock invocation) throws Throwable {
				int arg = (Integer) invocation.getArguments()[0];
				return arg + 20;
			}
		});

		assertEquals(30, dependency.addTwo(10));		
	}
	
	@Test
	public void testAddTwo(){		
		when(dependency.addTwo(1)).thenReturn(5);
		assertEquals(5, dependency.addTwo(1));	
		assertEquals(0, dependency.addTwo(27));
	}
	
	@Test
	public void testAddTwoAny(){		
		when(dependency.addTwo(anyInt())).thenReturn(0);
		assertEquals(0, dependency.addTwo(3));		
		assertEquals(0, dependency.addTwo(80));
	}
}
