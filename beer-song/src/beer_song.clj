(ns beer-song
  (:require [clojure.string :refer [join]]))

(defn bottles [beers]
  (cond
    (> beers 1)
    (str beers " bottles of beer")
    (= beers 1)
    (str beers " bottle of beer")))

(defn line1 [beers]
  (cond
    (> beers 0)
    (str (bottles beers) " on the wall, " (bottles beers) ".\n")
    :else "No more bottles of beer on the wall, no more bottles of beer.\n"))

(defn line2 [left]
  (cond
    (> left 0)
    (str "Take one down and pass it around, " (bottles left) " on the wall.\n")
    (= left 0)
    (str "Take it down and pass it around, no more bottles of beer on the wall.\n")
    (< left 0)
    (str "Go to the store and buy some more, " (bottles 99) " on the wall.\n")))

(defn verse [beers]
  (str (line1 beers)
       (line2 (dec beers))))

(defn sing
  ([start end]
   (join
    "\n"
    (for [x (range start (- end 1) -1)]
      (verse x))))
  ([start]
   (sing start 0)))


