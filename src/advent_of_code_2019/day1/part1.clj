(ns advent-of-code-2019.day1.part1
  (:require [advent-of-code-2019.utils.input :refer [numbers-from-file]]))

(defn calculate-fuel
  [mass]
  (- (int (Math/floor (/ mass 3))) 2))

(def result
  (apply +
         (map calculate-fuel (numbers-from-file "resources/day1_input.txt"))))

result