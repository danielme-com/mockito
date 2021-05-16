package com.danielme.blog.testdouble;

import org.junit.Test;
import org.mockito.MockedStatic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mockStatic;

public class StaticMethodTest {

    @Test
    public void testStaticMocked() {
        try (MockedStatic<BoolUtils> utilsMocked = mockStatic(BoolUtils.class)) {
            utilsMocked.when(() -> BoolUtils.isTrue(anyBoolean())).thenReturn(false);
            assertFalse(BoolUtils.isTrue(true));
            assertFalse(BoolUtils.isTrue(false));
            assertFalse(BoolUtils.isTrue(null));
        }
        assertTrue(BoolUtils.isTrue(true));
    }

}
