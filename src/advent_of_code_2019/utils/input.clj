(ns advent-of-code-2019.utils.input)

(defn numbers-from-file
  [file-path]
  (with-open [rdr (clojure.java.io/reader file-path)]
     (mapv #(Long/valueOf %) (line-seq rdr))))

(defn number-seq-from-file
  [file-path separator]
  (with-open [rdr (clojure.java.io/reader file-path)]
    (mapv #(Long/valueOf %) (-> (line-seq rdr)
                            first
                            (clojure.string/split (re-pattern separator))))))