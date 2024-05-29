select 
    t.customer_id, 
    count(t.customer_id) as "count_no_trans"
from
    (
        select 
            v.visit_id,
            v.customer_id
        from
            Visits v
        where
            v.visit_id
        not in
            (
                select distinct
                    v.visit_id
                from
                    Visits v
                join
                    Transactions t
                on
                    v.visit_id = t.visit_id
            )
    ) as t
group by
    t.customer_id;