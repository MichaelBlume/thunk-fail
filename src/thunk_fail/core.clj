(ns thunk-fail.core
  (:require [thunk-fail.source :as src]))

(defmacro defclone [here there]
  `(do 
     (def ~here ~there)
     (alter-meta! (var ~here) assoc
                  :doc (:doc (meta (var ~there)))
                  :arglists (:arglists (meta (var ~there)))
                  :file (:file (meta (var ~there)))
                  :line (:line (meta (var ~there)))
                  :column (:column (meta (var ~there))))
     (var ~here)))
                 
(defclone foo src/foo)
