#!/bin/bash

kubectl -n infra exec -it cockroachdb-client-secure -- cockroach sql --certs-dir=cockroach-certs --host=infra-cockroachdb-public

