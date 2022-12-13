package com.danielme.blog.testdouble;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class BDDMockitoTest {

    @Mock
    private Dependency dependency;

    @Test
    void testDependency() {
        //given
        given(dependency.getClassName()).willReturn("hi there");

        //when

        //then
        assertEquals("hi there", dependency.getClassName());
    }

    @Test
    void testVerify() {
        //given

        //when
        dependency.getClassNameUpperCase();

        //then
        then(dependency).should().getClassNameUpperCase();
        then(dependency).should(never()).getClassName();
    }

}
