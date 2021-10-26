#!/bin/bash

java -jar rsc-0.4.2.jar --debug --request --data "{\"message\":\"request?\"}" --route sample tcp://localhost:8000
