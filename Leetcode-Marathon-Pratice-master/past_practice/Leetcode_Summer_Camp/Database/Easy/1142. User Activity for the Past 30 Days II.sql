# Write your MySQL query statement below
with T as(
    select user_id, count(distinct session_id) as num_session
    from Activity
    where activity_date between date_sub('2019-07-27', interval 29 day) and '2019-07-27'
    group by user_id
)

select ifnull(round(sum(T.num_session) / count(T.user_id), 2), 0.00) as average_sessions_per_user
from T