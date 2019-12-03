(ns advent-of-code-2019.day1.part2
  (:require
    [advent-of-code-2019.day1.part1 :as part1]
    [advent-of-code-2019.utils.input :as input]))


(defn realistic-fuel
  [mass]
  (loop [fuel 0
         remaining-mass mass]
    (let [calculated-mass (part1/calculate-fuel remaining-mass)]
      (if (pos-int? calculated-mass)
        (recur (+ fuel calculated-mass) calculated-mass)
        fuel))))

(comment
  (->> (input/numbers-from-file "resources/day1_input.txt")
       (map realistic-fuel)
       (apply +))
  )