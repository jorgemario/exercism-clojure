(ns word-count
  (:require [clojure.string :refer [split lower-case]]))

(defn freq-map [map word]
  (update-in map [word] #(inc (if (nil? %) 0 %))))

(defn words-coll [input]
  (->
   input
   lower-case
   (split #"[^\w]+")))

(defn word-count [input] ;; <- arglist goes here
  (reduce freq-map {} (words-coll input)))

