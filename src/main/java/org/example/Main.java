package org.example;


public class Main {
    public static void main(String[] args) {
        DatabaseInitService.main(args);
        DatabasePopulateService.main(args);
        DatabaseQueryService queryService = new DatabaseQueryService();

        System.out.println("Clients:");
        queryService.findAllClients()
                .forEach(c -> System.out.println(c.getId() + " " + c.getName()));

        System.out.println("Projects:");
        queryService.findAllProjects()
                .forEach(p -> System.out.println(p.getId() + " " + p.getName()));

        System.out.println("Max project client:");
        queryService.findMaxProjectsClient()
                .forEach(c -> System.out.println(c.getName() + " : " + c.getProjectCount()));
    }
}