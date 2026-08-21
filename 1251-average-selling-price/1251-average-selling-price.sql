select p.product_id, coalesce(round(sum(p.price * s.units ) / sum(s.units),2),0) as average_price
from Prices as p
left join UnitsSold as s
using(product_id)
where s.purchase_date between p.start_date and p.end_date || s.purchase_date is null
group by product_id;