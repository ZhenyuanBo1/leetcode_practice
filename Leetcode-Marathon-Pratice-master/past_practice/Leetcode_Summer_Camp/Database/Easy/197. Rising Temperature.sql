SELECT W1.id
FROM Weather W1, Weather W2
WHERE DATEDIFF(W1.recordDate, W2.recordDate) = 1
and W1.temperature > W2.temperature;