
select t1.machine_id, round(avg(t2.timestamp - t1.timestamp),3) as processing_time
 from Activity as t1
join Activity as t2 using(machine_id, process_id) 
where t1.activity_type = 'start' and t2.activity_type = 'end'
group by machine_id;