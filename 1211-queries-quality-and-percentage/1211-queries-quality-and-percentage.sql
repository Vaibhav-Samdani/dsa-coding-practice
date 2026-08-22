# Write your MySQL query statement below
select query_name, round(avg(rating/position),2) as quality, round(SUM(rating < 3) * 100.0 / COUNT(*),2) as poor_query_percentage
from queries
group by query_name;


-- round(count(rating <= 1) * 100/count(query_name),2)