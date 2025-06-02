# 🧩 Proyecto de Microservicios con Kafka, Docker y GitHub Actions

Este proyecto es una arquitectura de microservicios en Java con Spring Boot que utiliza Kafka como sistema de mensajería, Docker para contenerización y GitHub Actions como CI.

## 📦 Microservicios

- `order-service`: recibe pedidos y los envía por Kafka
- `inventory-service`: escucha pedidos y valida stock
- `notification-service`: escucha pedidos y muestra notificaciones

## 🚀 Tecnologías utilizadas

- Java 17 + Spring Boot
- Apache Kafka
- Docker & Docker Compose
- GitHub Actions (CI)
- Maven

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/briancdevita/proyecto-microservicios
   cd proyecto-microservicios

2. Levantar Kafka y los servicios:
 cd docker
 docker compose up --build

3. Crear pedido (POST):
POST http://localhost:8080/orders
{
  "product": "Mouse",
  "quantity": 2
}

