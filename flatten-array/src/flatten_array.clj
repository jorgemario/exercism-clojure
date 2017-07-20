(ns flatten-array)

(defn flatten-rec
  [input result]
  (let [xs (filter some? input)
        x (first xs)]
    (cond
      (empty? xs)
      result
      (vector? x)
      (flatten-rec (concat x (rest xs)) result)
      :else
      (flatten-rec (rest xs) (conj result x)))))

(defn flatten
  [input]
  (flatten-rec input (vector)))


