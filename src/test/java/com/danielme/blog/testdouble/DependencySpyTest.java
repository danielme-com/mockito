package com.danielme.blog.testdouble;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class DependencySpyTest {

    @Spy
    private Dependency dependency = new Dependency(new SubDependency());


    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        //Dependency dependency = Mockito.spy(new Dependency(new SubDependency()));
    }

    @Test
    public void testOriginal() {
        assertEquals(7, dependency.addTwo(5));
    }

    @Test
    public void testSpy() {
        when(dependency.addTwo(Mockito.anyInt())).thenReturn(3);

        assertEquals(3, dependency.addTwo(27));
        assertEquals(SubDependency.class.getSimpleName(), dependency.getSubdependencyClassName());
    }

    @Test(expected = RuntimeException.class)
    public void testSurpriseMeWhenThen() {
        //when is calling the real method
        when(dependency.surpriseMe()).thenReturn("I love you!!!");
    }

    @Test
    public void testSurpriseMeDoWhen() {
		String niceSurprise = "I love you!!!";
		doReturn(niceSurprise).when(dependency).surpriseMe();

        assertEquals(niceSurprise, dependency.surpriseMe());
    }

}
