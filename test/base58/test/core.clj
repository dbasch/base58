(ns base58.test.core
  (require [clojure.test :refer [deftest testing is]]
           [base58.core :as b]))

(deftest test_core []
  (testing
      "a valid address"
    (is (b/valid? "DDQ3mUxnmJHmsEux8Mb5ZSYs1VQysCrK6k")))
  (testing
      "an invalid address"
    (is (not (b/valid? "DDQ3mUxnmJHmsEux8Mb5ZSYs1VQysCrK6j"))))
  (testing
      "round trip")
  (is "DDQ3mUxnmJHmsEux8Mb5ZSYs1VQysCrK6k" (b/encode (b/decode "DDQ3mUxnmJHmsEux8Mb5ZSYs1VQysCrK6k")))
    (testing
        "full address encoding")
    (let [payload (-> "DDQ3mUxnmJHmsEux8Mb5ZSYs1VQysCrK6k"
                      b/decode
                      b/get-payload)
          add (b/encode-check payload (byte 30))]
      (is "DDQ3mUxnmJHmsEux8Mb5ZSYs1VQysCrK6k" add)))