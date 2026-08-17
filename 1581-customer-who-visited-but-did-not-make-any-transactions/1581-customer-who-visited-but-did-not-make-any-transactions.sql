select customer_id, count(*) as count_no_trans
from visits as v
left join Transactions as t using(visit_id)
where t.visit_id is null
GROUP BY v.customer_id;