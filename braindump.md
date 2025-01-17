# Braindump

test/instrument is a little confusing, how do i run this

- ahhh this just checks :args :P

so seems you'd have this on in prod

test/check - this does the work, it also gives back number of tests and a seed

however results back are crazy hard to read

`(-> (stest/enumerate-namespace 'user) stest/check)` will test everything

can stub a function, now it will use generator stuff

```clj
(stest/instrument `invoke-service {:stub #{`invoke-service}})
```

function predicates are confusing, but that's likely the me trying to jump the gun without understanding clojure

in one go, someone wrote a [macro](https://github.com/danielcompton/defn-spec)

```clj
;; Predicate definitions elided for brevity
(s/def ::instant instant?)
(s/def ::zone-id zone-id?)
(s/def ::zoned-date-time zoned-date-time?)
```

default way

```clj
(defn to-zoned-dt
  [instant zone-id]
  (ZonedDateTime/ofInstant instant zone-id))

(s/fdef to-zoned-dt
        :args (s/cat :instant ::instant :zone-id ::zone-id)
        :ret ::zoned-date-time)
```

alt

```clj
(ds/defn to-zoned-dt :- ::zoned-date-time
  [instant :- ::instant
   zone-id :- ::zone-id]
  (ZonedDateTime/ofInstant instant zone-id))
```
