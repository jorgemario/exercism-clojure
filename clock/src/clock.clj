(ns clock
  (:require [clojure.string :refer [split]]))

(defn clock [hours mins]
  (let [mm (mod mins 60)
        plus-hh (- (.intValue (/ mins 60)) (if (neg? mins) 1 0))
        hh (mod (+ hours plus-hh) 24)]
    (vector hh mm)))

(defn clock->string [clock-v]
  (format "%02d:%02d" (first clock-v) (second clock-v)))

(defn add-time [clock-v add]
  (clock (first clock-v) (+ (second clock-v) add)))

;(clock->string (add-time (clock 6 41) 0))

