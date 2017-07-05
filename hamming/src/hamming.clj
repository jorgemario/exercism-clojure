(ns hamming)

(defn distance [a b]
  (when (= (count a) (count b))
    (reduce + 0 (map #(if % 0 1) (map = a b)))))

