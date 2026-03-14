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

        System.out.println("Max salary worker:");
        queryService.findMaxSalaryWorker()
                .forEach(c -> System.out.println(c.getName() + " : " + c.getSalary()));

        System.out.println("Longest project:");
        queryService.findLongestProject()
                .forEach(c -> System.out.println(c.getName() + " : " + c.getMonthCount() + " months"));

        System.out.println("Youngest/Eldest workers:");
        queryService.findYoungestEldestWorkers()
                .forEach(c -> System.out.println(c.getType() + " : " + c.getName() + " - " + c.getBirthday()));

        System.out.println("Project prices:");
        queryService.printProjectPrices()
                .forEach(c -> System.out.println(c.getName() + " : " + c.getPrice()));
    }
}