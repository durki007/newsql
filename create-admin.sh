#!/bin/bash

if [ $# -ne 2 ]; then
  echo "Usage: $0 <username> <password>"
  exit 1
fi

USERNAME="$1"
PASSWORD="$2"
NAMESPACE="infra"
POD="cockroachdb-client-secure"
CERT_DIR="cockroach-certs"
HOST="infra-cockroachdb-public"

kubectl -n "$NAMESPACE" exec -it "$POD" -- \
  cockroach sql \
    --certs-dir="$CERT_DIR" \
    --host="$HOST" \
    -e "CREATE USER IF NOT EXISTS $USERNAME WITH PASSWORD '$PASSWORD'; GRANT admin TO $USERNAME;"

# kubectl -n infra exec -it cockroachdb-client-secure -- cockroach sql --certs-dir=cockroach-certs --host=infra-cockroachdb-public

