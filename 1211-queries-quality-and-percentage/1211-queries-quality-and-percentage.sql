# Write your MySQL query statement below
SELECT q.query_name, 
round(AVG(q.rating/q.position),2) AS quality,
round(SUM(IF(rating<3,1,0))/count(*)*100,2) AS poor_query_percentage
FROM Queries q
WHERE q.query_name IS NOT null
GROUP BY q.query_name;