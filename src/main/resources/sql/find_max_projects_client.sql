SELECT cl.name,
       COUNT(proj.id) AS project_count
FROM client AS cl
    JOIN project AS proj
        ON cl.id = proj.client_id
GROUP BY cl.name

HAVING COUNT(proj.id) = (
    SELECT MAX(project_count)
    FROM (
        SELECT COUNT(*) AS project_count
        FROM project
        GROUP BY client_id
    )
);