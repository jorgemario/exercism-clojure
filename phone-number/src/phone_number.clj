(ns phone-number)

(def phone-pattern #"^1?[^\d]*([\d]{3})[^\d]*([\d]{3})[^\d]*([\d]{4})$")

(defn number [num]
  (let [match (re-find phone-pattern num)]
    (cond
      (nil? match)
      "0000000000"
      :else
      (reduce str (rest match)))))

(defn area-code [num]
  (let [match (re-find phone-pattern num)]
    (when match
      (nth match 1))))

(defn pretty-print [num]
  (let [match (re-find phone-pattern num)]
    (when match
      (apply format "(%s) %s-%s" (rest match)))))

