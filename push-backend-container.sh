#!/bin/bash

if [ -z $1 ]; then
  echo "Usage: $0 <version>"
  exit 1
fi

version="$1"

az acr login --name databaseregistry
docker build ./backend-spring/ -t backend:$version
docker tag backend:$version databaseregistry.azurecr.io/backend:$version
docker push databaseregistry.azurecr.io/backend:$version
