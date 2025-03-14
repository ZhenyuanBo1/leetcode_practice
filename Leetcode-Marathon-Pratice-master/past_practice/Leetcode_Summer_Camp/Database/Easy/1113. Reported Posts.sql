# Write your MySQL query statement below
select a.extra as report_reason, count(distinct a.post_id) as report_count
from Actions a
where a.extra is not null and a.action_date = '2019-07-04' and a.action = 'report'
group by a.extra, a.action_date