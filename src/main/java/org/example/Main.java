package org.example;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        DatabaseInitService.main(args);
        DatabasePopulateService.main(args);
        DatabaseQueryService queryService = new DatabaseQueryService();
        List<MaxProjectCountClient> maxProjectClients =
                queryService.findMaxProjectsClient();

        System.out.println("MaxProjectCountClient:");
        for (MaxProjectCountClient client : maxProjectClients) {
            System.out.println(client.getName() + " : " + client.getProjectCount());
        }
    }
}