(ns clj.core
  (:gen-class)
  (:require [clojure.spec.gen.alpha :as gen])
  (:require [clojure.spec.test.alpha :as stest])
  (:require [clojure.spec.alpha :as s]))

(s/def ::n number?)
(s/def ::s string?)
(s/def ::n-or-s (s/or :n ::n :s ::s))

(s/def ::foo (s/keys :req [::n ::s]))

(s/explain ::foo {::n "hhh" ::s "hey"})

(s/valid? ::n-or-s 3)
(s/conform (s/cat :x ::n-or-s :y (s/alt :nnn number? :sss string?)) [3 "hi"])
(s/conform (s/coll-of number?) [1 2 3])
(s/conform (s/coll-of ::n-or-s) [1 "hi" 3])
(s/conform (s/coll-of ::n-or-s) [1 3 3])
