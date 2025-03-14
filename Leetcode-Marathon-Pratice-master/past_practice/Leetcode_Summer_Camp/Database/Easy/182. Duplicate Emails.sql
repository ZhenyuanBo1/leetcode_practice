# Write your MySQL query statement below
SELECT DISTINCT P1.Email
FROM Person P1 JOIN Person P2
WHERE P1.Id != P2.Id and P1.Email = P2.Email