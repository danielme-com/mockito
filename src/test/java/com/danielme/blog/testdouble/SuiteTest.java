package com.danielme.blog.testdouble;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   DependencyMockTest.class,
   DependencyMockTest2.class,
   DependencySpyTest.class,
   DependencyVerifyTest.class
})
public class SuiteTest {

}
