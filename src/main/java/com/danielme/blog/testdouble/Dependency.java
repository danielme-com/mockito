package com.danielme.blog.testdouble;

public class Dependency {

    private final SubDependency subDependency;

    public Dependency(SubDependency subDependency) {
        super();
        this.subDependency = subDependency;
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public String getSubdependencyClassName() {
        return subDependency.getClassName();
    }

    public int addTwo(int i) {
        return i + 2;
    }

    public String getClassNameUpperCase() {
        return getClassName().toUpperCase();
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public String surpriseMe() {
        throw new RuntimeException("Ah-Ha!");
    }

}
