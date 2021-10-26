#!/bin/bash

#java -jar rsc-0.4.2.jar --help

java -jar rsc-0.4.2.jar --debug --request --data "{\"message\":\"request?\"}" --route sample tcp://localhost:7000
java -jar rsc-0.4.2.jar --debug --request --route graph-random tcp://localhost:7000
