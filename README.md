# clj

[Spec docs](https://clojure.org/guides/spec)
[lang cheatsheet](https://learnxinyminutes.com/clojure)

## Setup

#### Prerequisite

```sh
brew install leiningen
git clone git@github.com:codethread/clojure-spec-playground.git
```

More info at:

- https://leiningen.org/
- https://leiningen.org/tutorial.html

#### Running

```sh
cd clojure-spec-playground
lein repl
# inside repl, import the namespace with reload
# for simplicity just write code that runs in `core.clj` and re-run:
$ (use 'clj.core :reload)
```

## Notes

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

## License

Copyright © 2025 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
