package com.danielme.blog.testdouble;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.danielme.blog.testdouble.SubDependency;

public class DependencySpyTest {

	private Dependency dependency;

	@Before
	public void setupMock() {
		dependency = spy(new Dependency(new SubDependency()));
	}

	@Test
	public void testOriginal() {
		assertEquals(7, dependency.addTwo(5));
	}

	@Test
	public void testSpy() {
		when(dependency.addTwo(Mockito.anyInt())).thenReturn(3);

		assertEquals(3, dependency.addTwo(27));
		assertEquals(SubDependency.class.getSimpleName(), dependency.getSubdepedencyClassName());
	}

}
