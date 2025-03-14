update Salary
set
    sex = CASE sex
        when 'm' then 'f'
        else 'm'
        end;

#need revisit