# Write your MySQL query statement below
select query_name, round(avg(rating/position), 2) as quality,

ifnull(round(sum(case when rating<3 then 1 end) / count(query_name)*100, 2), 0.00) as poor_query_percentage
from Queries
group by query_name