#!/bin/bash

az acr login --name databaseregistry
docker build ./backend/ -t backend:latest
docker tah backend databaseregistry.azurecr.io/backend
docker push databaseregistry.azurecr.io/backend
