(ns robot-name)

(def db (atom #{}))

(defn fname []
  (apply str (for [n (range 3)]
               (char (+ 65 (rand-int 26))))))

(defn lname []
  (apply str (for [n (range 3)]
               (rand-int 9))))

(defn full-name []
  (str (fname) (lname)))

(defn new-name []
  (loop [n (full-name)]
    (if (contains? @db n)
      (recur (full-name))
      (do
        (swap! db conj n)
        n))))

(defn robot []
  {:name (atom (new-name))})

(defn robot-name [robot]
  (deref (:name robot)))

(defn reset-name [robot]
  (do
    (reset! (:name robot) (new-name))
    robot))


