package io.forward.kafka

import java.util.Properties

import kafka.javaapi.producer.Producer
import kafka.producer.{KeyedMessage, ProducerConfig}

final class KafkaProducer[K,V](topic: String, properties: Properties = defaultProducerProperties) {
  private val config = new ProducerConfig(properties)

  private val producer: Producer[K, V] = new Producer[K,V](config)

  /**
   * Send a message with a partition key set
   *
   * @param key The partition key
   * @param value The message value
   */
  def sendWithKey(key: K, value: V): Unit =
    producer.send(
      new KeyedMessage[K,V](topic, key, value))

  /**
   * Send a message
   *
   * @param value The message value
   */
  def send(value: V): Unit =
    producer.send(new KeyedMessage[K,V](topic, value: V))
}
