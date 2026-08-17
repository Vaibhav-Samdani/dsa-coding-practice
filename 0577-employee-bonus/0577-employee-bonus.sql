select e.name, b.bonus
from Employee as e
left join bonus as b using(empId)
where b.bonus < 1000 or b.bonus is null;