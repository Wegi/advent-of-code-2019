(ns advent-of-code-2019.day2.part1
  (:require [advent-of-code-2019.utils.input :as input]))


(defn calculate-1202
  [program]
  (loop [program program
         pos 0]
    (let [[opcode pos1 pos2 target] (subvec program pos (+ 4 pos))]
      (case opcode
        1 (recur (assoc program target (+ (get program pos1) (get program pos2))) (+ 4 pos))
        2 (recur (assoc program target (* (get program pos1) (get program pos2))) (+ 4 pos))
        99 program
        (throw Exception)))))

(comment
  (first (calculate-1202 (input/number-seq-from-file "resources/day2_input.txt" ",")))
  )