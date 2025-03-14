# Write your MySQL query statement below
with T as
(
    select sub_id
    from Submissions
    where parent_id is null

),

T1 as
(
    select parent_id, count(distinct sub_id) as number_of_comments
    from Submissions
    where parent_id is not null
    group by parent_id
)

select distinct T.sub_id as post_id, ifnull(t1.number_of_comments, 0) as number_of_comments
from T left join T1 on T.sub_id = T1.parent_id
order by T.sub_id