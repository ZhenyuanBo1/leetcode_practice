with t as(
    select num, count(*) occurence
    from my_numbers
    group by num
)


select max(num) as num
from t
where occurence = 1;