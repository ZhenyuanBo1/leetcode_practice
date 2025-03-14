# Write your MySQL query statement below
select round(
    (select count(delivery_id) from Delivery where order_date = customer_pref_delivery_date) /
    (select count(delivery_id) from Delivery)*100, 2
) as immediate_percentage