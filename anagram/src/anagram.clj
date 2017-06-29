(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn freq-map [word]
  (let [freq-fn (fn [map letter] (update-in map [letter] (fnil inc 0)))]
    (reduce freq-fn {} (seq (lower-case word)))))

(defn is-anagram? [word]
  "Returns a function that allows to compare an specific word against
  anagram candidates. It does resolve the predicate by creating frequency
  maps of each character in comparing words. An anagram must have the
  same char frequency. Also a particular word is not an anagram of itself."
  (fn [candidate]
    (and (not (.equalsIgnoreCase word candidate))
         (= (freq-map word) (freq-map candidate)))))

(defn anagrams-for [word anagrams] ;; <- arglist goes here
  (let [filter-fn (is-anagram? word)]
    (filter filter-fn anagrams)))

