(ns etl
  (require [clojure.string :refer [lower-case]]))

(defn transform [old-map]
  (into {}
        (for [score (keys old-map)
              word (get old-map score)]
          [(lower-case word) score])))


