package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DatabaseQueryService {

    private String readSql(String file) {
        return new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("sql/" + file))
                )
        ).lines().collect(Collectors.joining("\n"));
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {

        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = readSql("find_max_projects_client.sql");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                result.add(new MaxProjectCountClient(
                        rs.getString("name"),
                        rs.getInt("project_count")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<Client> findAllClients() {

        List<Client> clients = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = readSql("find_all_clients.sql");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                clients.add(new Client(
                        rs.getLong("id"),
                        rs.getString("name")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    public List<Project> findAllProjects() {

        List<Project> projects = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = readSql("find_all_projects.sql");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                projects.add(new Project(
                        rs.getLong("id"),
                        rs.getString("name")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {

        List<MaxSalaryWorker> workers = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = readSql("find_max_salary_worker.sql");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                workers.add(new MaxSalaryWorker(
                        rs.getInt("salary"),
                        rs.getString("name")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return workers;
    }

    public List<LongestProject> findLongestProject() {

        List<LongestProject> projects = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = readSql("find_longest_project.sql");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                projects.add(new LongestProject(
                        rs.getString("name"),
                        rs.getInt("month_count")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {

        List<YoungestEldestWorker> workers = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();

            String sql = readSql("find_youngest_eldest_workers.sql");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                workers.add(new YoungestEldestWorker(
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getDate("birthday")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return workers;
    }

    public List<ProjectPrice> printProjectPrices() {

        List<ProjectPrice> prices = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();

            String sql = readSql("print_project_prices.sql");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                prices.add(new ProjectPrice(
                        rs.getString("name"),
                        rs.getInt("price")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return prices;
    }
}