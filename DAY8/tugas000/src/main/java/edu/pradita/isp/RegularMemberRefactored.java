package edu.pradita.isp;

public class RegularMemberRefactored implements BookableRefactored {
    private String name;

    public RegularMemberRefactored(String name) {
        this.name = name;
    }

    @Override
    public void bookClass(String className) {
        System.out.println("[ISP] " + name + " booked class: " + className);
    }
}