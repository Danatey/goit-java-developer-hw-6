package org.example;

import java.sql.Connection;
import java.sql.Statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

public class DatabaseInitService {

    public static void main(String[] args) {

        try {
            Connection conn = Database.getInstance().getConnection();

            String sql = new BufferedReader(
                    new InputStreamReader(
                            Objects.requireNonNull(DatabaseInitService.class
                                    .getClassLoader()
                                    .getResourceAsStream("sql/init_db.sql"))
                    )
            ).lines().collect(Collectors.joining("\n"));

            String[] queries = sql.split(";");

            try (Statement statement = conn.createStatement()) {
                for (String query : queries) {
                    if (!query.trim().isEmpty()) {
                        statement.execute(query);
                    }
                }
            }

            System.out.println("Database initialized!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}