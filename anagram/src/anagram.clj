(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn freq-map [word]
  (frequencies (lower-case word)))

(defn is-anagram? [word candidate]
  "Returns a function that allows to compare an specific word against
  anagram candidates. It does resolve the predicate by creating frequency
  maps of each character and comparing the resulting maps. 
  Also, a particular word is not an anagram of itself."
  (and (not (.equalsIgnoreCase word candidate))
       (= (freq-map word) (freq-map candidate))))

(defn anagrams-for [word candidates] ;; <- arglist goes here
  (let [filter-fn (partial is-anagram? word)]
    (filter filter-fn candidates)))

