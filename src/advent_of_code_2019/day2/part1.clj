(ns advent-of-code-2019.day2.part1
  (:require [advent-of-code-2019.utils.input :as input]))


(defn calculate-1202
  [program noun verb]
  (loop [program (assoc (assoc program 1 noun) 2 verb)
         pos 0]
    (let [[opcode pos1 pos2 target] (subvec program pos (+ 4 pos))]
      (case opcode
        1 (recur (assoc program target (+ (get program pos1) (get program pos2))) (+ 4 pos))
        2 (recur (assoc program target (* (get program pos1) (get program pos2))) (+ 4 pos))
        99 program
        (throw Exception)))))

(comment
  (first (calculate-1202 (input/number-seq-from-file "resources/day2_input.txt" ",") 12 2))
  )

(defn bruteforce
  [program]
  (into {}
        (for [noun (range 100)
              verb (range 100)]
          [(first (calculate-1202 program noun verb)) [noun verb]])))

(def solutions (bruteforce (input/number-seq-from-file "resources/day2_input.txt" ",")))

(def result (+ (* 100 (first (solutions 19690720))) (second (solutions 19690720))))