# Write your MySQL query statement below
select distinct c.title
from TVProgram t, Content c
where t.content_id = c.content_id
        and c.Kids_content = 'Y'
        and c.content_type = 'Movies'
        and t.program_date between '2020-06-01' and '2020-06-30'