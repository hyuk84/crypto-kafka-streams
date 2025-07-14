#!/bin/bash

echo "[INFO] Removing old Kafka/Zookeeper data directories..."
rm -rf ./docker/data/kafka
rm -rf ./docker/data/zookeeper

echo "[INFO] Starting Kafka and Zookeeper using Docker Compose..."
docker-compose -f ./docker/docker-compose.yml up -d

echo "[INFO] Waiting for Kafka to be ready..."
sleep 10

echo "[INFO] Creating topic: upbit-ticker"
docker exec kafka kafka-topics --create \
  --topic upbit-ticker \
  --bootstrap-server localhost:9092 \
  --replication-factor 1 \
  --partitions 1

echo "[INFO] Kafka setup complete"