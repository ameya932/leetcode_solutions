# Write your MySQL query statement below
SELECT Users.name, IFNULL(SUM(Rides.distance), 0) AS travelled_distance
FROM Users LEFT JOIN Rides
ON Users.id = Rides.user_id
GROUP BY user_id
ORDER BY travelled_distance DESC,
name ASC; 