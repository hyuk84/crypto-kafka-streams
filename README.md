# 🔥 crypto-kafka-streams

Real-time cryptocurrency stream processing using **Kafka**, **Kafka Streams**, and **Redis**.  
This project consumes live ticker data from **Upbit's WebSocket API**, processes it via Kafka Streams, and exposes real-time analytics through a REST API.

---

## 🧱 Architecture

```plaintext
[ Upbit WebSocket API ]
           ↓
[ Kafka Producer (Spring Boot) ]
           ↓
[ Kafka Topic: coin-ticker ]
           ↓
[ Kafka Streams Processor ]
           ↓
[ Redis: volume, alerts ]
           ↓
[ Spring Boot API Server ]
