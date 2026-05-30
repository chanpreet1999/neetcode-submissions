-- Write your query below
select employee_id,
CASE 
    WHEN employee_id % 2 = 1 and name NOT like 'M%'
    THEN salary
ELSE
    0
END AS bonus 
from employees
order by employee_id;
