package com.danielme.blog.testdouble;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DependencyVerifyTest {

    @Mock
    private Dependency dependency;

    @Test
    void testSimpleVerify() {
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
    void testParameters() {
        dependency.addTwo(3);
        //una vez con el parámetro 3
        verify(dependency, times(1)).addTwo(3);

        dependency.addTwo(4);
        //dos veces con cualquier parámetro
        verify(dependency, times(2)).addTwo(anyInt());
    }

}
