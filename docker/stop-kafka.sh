#!/bin/bash

echo "[INFO] Stopping Kafka and Zookeeper..."

docker compose -f ./docker/docker-compose.yml down