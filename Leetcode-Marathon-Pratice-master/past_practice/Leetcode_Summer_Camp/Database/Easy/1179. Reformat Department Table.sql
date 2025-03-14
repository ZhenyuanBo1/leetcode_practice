# Write your MySQL query statement below
select id
    , sum(case when month = 'Jan' then revenue end) as Jan_Revenue
    , sum(case when month = 'Feb' then revenue end) as Feb_Revenue
    , sum(case when month = 'Mar' then revenue end) as Mar_Revenue
    , sum(Case When Month = 'Apr' Then Revenue End) as Apr_Revenue
    , sum(Case When Month = 'May' Then Revenue End) as May_Revenue
    , sum(Case When Month = 'Jun' Then Revenue End) as Jun_Revenue
    , sum(Case When Month = 'Jul' Then Revenue End) as Jul_Revenue
    , sum(Case When Month = 'Aug' Then Revenue End) as Aug_Revenue
    , sum(Case When Month = 'Sep' Then Revenue End) as Sep_Revenue
    , sum(Case When Month = 'Oct' Then Revenue End) as Oct_Revenue
    , sum(Case When Month = 'Nov' Then Revenue End) as Nov_Revenue
    , sum(Case When Month = 'Dec' Then Revenue End) as Dec_Revenue
from Department
group by id