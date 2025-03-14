with T as(
    select class, count(distinct student) num
    from courses
    group by class
)

select T.class
from T
where T.num>=5