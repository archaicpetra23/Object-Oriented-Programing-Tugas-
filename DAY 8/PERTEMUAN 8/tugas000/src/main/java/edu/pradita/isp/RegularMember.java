package edu.pradita.isp;

public class RegularMember implements GymUser {
    private String name;

    public RegularMember(String name) {
        this.name = name;
    }

    @Override
    public void bookClass(String className) {
        System.out.println(name + " booked class: " + className);
    }

    @Override
    public void manageMember(String memberName) {
        throw new UnsupportedOperationException("Regular members cannot manage other members.");
    }

    @Override
    public void viewReport(String reportName) {
        throw new UnsupportedOperationException("Regular members cannot view admin reports.");
    }
}