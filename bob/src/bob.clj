(ns bob
  (:require [clojure.string :refer :all]))

(defn re-contains? [p s]
  "Check if s string contains p pattern"
  (not (empty? (re-find (re-pattern (str "[" p "]+")) s))))

(defn yelling? [input]
  "Yelling if all letters are upper case.
  There should not have lower case letters and definitely 
  should have upper case letters."
  (and (not (re-contains? "a-z" input))
       (re-contains? "A-Z" input)))

(defn question? [input]
  (and (not (yelling? input))
       (ends-with? input "?")))

(defn response-for
  ([input]
   (cond
     (empty? (trim input))
     "Fine. Be that way!"
     (yelling? input)
     "Whoa, chill out!"
     (question? input)
     "Sure."
     :else
     "Whatever."))
  ([]
   (response-for "")))


