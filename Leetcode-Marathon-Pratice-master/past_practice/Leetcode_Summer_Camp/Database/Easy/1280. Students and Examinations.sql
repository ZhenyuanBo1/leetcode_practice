# Write your MySQL query statement below
with T as(
    select s.student_id, s.student_name, sub.subject_name
    from Students s, Subjects sub
)

select T.student_id, T.student_name, T.subject_name, count(e.subject_name) as attended_exams
from T left join Examinations e on T.student_id = e.student_id and T.subject_name = e.subject_name
group by T.student_id, T.student_name, T.subject_name, e.subject_name
order by T.student_id