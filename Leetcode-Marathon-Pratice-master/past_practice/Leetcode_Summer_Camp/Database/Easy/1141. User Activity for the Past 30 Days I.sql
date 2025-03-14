# Write your MySQL query statement below
select a.activity_date day, count(distinct user_id) as active_users
from Activity a
where a.activity_date between date_sub('2019-07-27', interval 29 day) and '2019-07-27'
group by a.activity_date