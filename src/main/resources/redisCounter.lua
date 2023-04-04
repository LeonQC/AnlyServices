local nextId = redis.call("INCR", KEYS[1])
return nextId