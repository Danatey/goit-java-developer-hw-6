package org.example;

public class LongestProject {
    private final String name;
    private final int monthCount;

    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() { return name; }

    public long getMonthCount() { return monthCount; }
}
