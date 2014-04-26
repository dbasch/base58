# base58

Bitcoin Base58 encoding and decoding.

## Install

From [Clojars](https://clojars.org/base58)

    [base58 "0.1.0"]

## Usage examples

Create a WIF Bitcoin key

    base58.core> (def k (->> (repeatedly #(- 127 (rand-int 256))) 
                             (take 32) 
                             (map byte)
                             byte-array))
    #'base58.core/k
    base58.core> (encode-check k (byte -128))
    "5JQoCAYwTs9dFvHoPJN92C3cZsaTgvE6A5fcggttnWTqaZerUCZ"
    
Test a Bitcoin address for a valid checksum

    base58.core> (valid? "1EmwBbfgH7BPMoCpcFzyzgAN9Ya7jm8L1Z")
    true
    base58.core> (valid? "1EmwBbfgH7BPMoCpcFzyzgAN9Ya7jm8L1Y")
    false
    
Decode a Bitcoin address string into the original 160-bit hash of a public key

    base58.core> (def h (-> "1EmwBbfgH7BPMoCpcFzyzgAN9Ya7jm8L1Z" decode get-payload))
    #'base58.core/h
    base58.core> (map byte h)
    (-105 25 42 -66 38 71 74 45 75 -59 51 -116 126 80 1 -114 73 74 9 29)

See the source for other useful functions.

## License

Copyright © 2014 Diego Basch

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
