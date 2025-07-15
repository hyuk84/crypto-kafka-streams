#!/bin/bash

echo "[INFO] Starting Kafka and Zookeeper with Docker Compose..."

# -d 옵션: 백그라운드 실행
docker compose -f ./docker/docker-compose.yml up -d

echo "[INFO] Kafka cluster is starting..."