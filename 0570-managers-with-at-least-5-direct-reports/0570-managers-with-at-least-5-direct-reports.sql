# Write your MySQL query statement below

select e1.name 
from Employee e1
where id in (select e2.managerId as id
from Employee as e2
group by e2.managerId having count(e2.managerId) >= 5);