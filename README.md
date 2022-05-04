# Install rabbitmq
1- Install rabbitmq
2- Create admin uesr 'irfan' with password 'irfan' in rabbitmq
3- Create queue with name 'iot_queue'.
4- Bind this queue with exchange 'amq.topic' with routing key 'iot'

# Install redis

1- Install redis
2- Change port 8885 from file redis.conf

# Rabbitmq_consumer_producer

1- Import maven project into IntelliJ
2- For producer run file 'RabbitMqCustomProducer' it will send message in rabbitmq (For testing)
3- Run consumer '' to consume rabbitmq messages and ingest into redis.


