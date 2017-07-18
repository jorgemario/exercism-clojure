(ns grade-school)

(defn add [db name grade]
  (update-in db [grade] #((fnil conj []) %1 %2) name))

(defn grade [db grade]
  (get-in db [grade] []))


(defn sorted [db]
  (into (sorted-map)
        (for [[grade names] db]
          [grade (into [] (sort names))])))


