(ns rna-transcription)

(def dna-rna-map {\A \U
                  \T \A
                  \C \G
                  \G \C})

(defn- dna->rna [c]
  (assert (contains? dna-rna-map c))
  (str (get dna-rna-map c)))

(defn to-rna [dna] ;; <- arglist goes here
  (clojure.string/join (map dna->rna dna)))

