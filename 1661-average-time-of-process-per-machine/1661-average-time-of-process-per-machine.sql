# Write your MySQL query statement below


select newtable.machine_id, round(avg(newtable.total_time),3) as processing_time from (
    select machine_id, process_id, ( t2.timestamp - t1.timestamp ) as total_time 
from Activity as t1
join Activity as t2 using(machine_id, process_id) 
where t1.activity_type = 'start' and t2.activity_type = 'end'
) as newtable group by newtable.machine_id;