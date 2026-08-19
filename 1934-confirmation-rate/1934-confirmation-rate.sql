# Write your MySQL query statement below
select s.user_id, ROUND(COALESCE(AVG(c.action = 'confirmed'), 0), 2) as confirmation_rate
from Signups as s
left join Confirmations as c using(user_id)
group by s.user_id;