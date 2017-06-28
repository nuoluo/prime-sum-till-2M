(ns prime-sum.core
  (:gen-class))

(defn is-prime?
  [list n]
  (not-any? #(= 0 (mod n %)) (take-while #(< % (inc (Math/sqrt n))) list)))

(def prime-seq (filter #(is-prime? prime-seq %) (cons 2 (iterate (partial + 2) 3))))

(defn sum* [n]
  (reduce #(+ %1 %2) 0 (take-while #(< % 2000000) prime-seq)))

(defn -main
  "Find the sum of all prime numbers below 2,000,000"
  []
  (let [sum (time (sum* 2000000))]
    (println "The sum of all prime numbers below 2,000,000 is" sum)))
