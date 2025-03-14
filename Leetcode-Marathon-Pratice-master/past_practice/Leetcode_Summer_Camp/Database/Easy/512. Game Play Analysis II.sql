WITH T AS(
    select player_id, min(event_date) as first_date
    from Activity
    group by player_id
)

select A1.player_id, A1.device_id
from Activity A1 join T on A1.player_id = T.player_id and A1.event_date = T.first_date