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

    public List<MaxProjectCountClient> findMaxProjectsClient() {

        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();

            String sql = new BufferedReader(
                    new InputStreamReader(
                            Objects.requireNonNull(getClass().getClassLoader()
                                    .getResourceAsStream("sql/find_max_projects_client.sql"))
                    )
            ).lines().collect(Collectors.joining("\n"));

            try (Statement statement = conn.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    int projectCount = rs.getInt("project_count");

                    result.add(new MaxProjectCountClient(name, projectCount));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
