import redis
from redis import Redis

con = redis.StrictRedis(host='localhost', port=6379, db=0, socket_timeout=2, socket_connect_timeout=2, encoding='utf-8', retry_on_timeout=False)


con.zadd("top10",  20.0, "joke1")
con.zadd("top10",  10.0, "joke2")
con.zadd("top10",  15.0, "joke3")
con.zadd("top10",  30.0, "joke4")
con.zadd("top10",  25.0, "joke5")
con.zadd("top10",  5.0, "joke6")
con.zadd("top10",  1.0, "joke7")
con.zadd("top10",  30.0, "joke8")
con.zadd("top10",  35.0, "joke9")
con.zadd("top10",   11.0, "joke10")
con.zadd("top10",   13.0, "joke11")
con.zadd("top10",   14.0, "joke12")
con.zadd("top10",   9.0, "joke13")
con.zadd("top10",   8.0, "joke14")
con.zadd("top10",   13.0, "joke15")

con.zincrby("top10", "joke10")
con.zincrby("top10", "joke12")


con.zrange("top10", 0, 9, True)