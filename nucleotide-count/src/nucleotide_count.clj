(ns nucleotide-count)

(def initial-freq {\A 0 \T 0 \C 0 \G 0})

(defn nucleotide-counts [dna]
  (merge initial-freq (frequencies dna)))

(defn count [nucleotid dna]
  (or (get (nucleotide-counts dna) nucleotid) (assert false)))
