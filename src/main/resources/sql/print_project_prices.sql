SELECT proj.id,
       proj.name,
       SUM(wor.salary) * DATEDIFF('month', proj.start_date, proj.finish_date) AS price
FROM project AS proj
JOIN project_worker AS pw
    ON proj.id = pw.project_id
JOIN worker AS wor
    ON pw.worker_id = wor.id
GROUP BY proj.id;