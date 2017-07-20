(ns sublist)

(defn classify-sub
  [xs ys]
  (cond
    (> (count xs) (count ys)) false
    (= (take (count xs) ys) xs) true
    :else (classify-sub xs (rest ys))))

(defn classify-sup
  [xs ys]
  (cond
    (< (count xs) (count ys)) false
    (= (take (count ys) xs) ys) true
    :else (classify-sup (rest xs) ys)))

(defn classify-eq
  [xs ys]
  (= xs ys))

(defn classify
  [xs ys]
  (cond
    (< (count xs) (count ys)) (if (classify-sub xs ys) :sublist :unequal)
    (> (count xs) (count ys)) (if (classify-sup xs ys) :superlist :unequal)
    :else (if (classify-eq xs ys) :equal :unequal)))
