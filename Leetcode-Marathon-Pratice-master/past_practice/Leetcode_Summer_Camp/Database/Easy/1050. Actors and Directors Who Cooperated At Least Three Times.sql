
with t as (
    select actor_id, director_id, count(director_id) as num
    from ActorDirector
    group by actor_id, director_id
    having num>=3
)

select t.actor_id, t.director_id from t;