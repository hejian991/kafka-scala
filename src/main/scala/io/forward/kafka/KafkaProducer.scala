package io.forward.kafka

import java.util.Properties

import io.forward.kafka.prop.PropertyBuilder
import kafka.javaapi.producer.Producer
import kafka.producer.{KeyedMessage, ProducerConfig}

object Props {
  val default: Properties = {
    PropertyBuilder.buildFromMap(
      Map("zk.connect"           -> "127.0.0.1:2181",
          "metadata.broker.list" -> "localhost:9092",
          "serializer.class"     -> "kafka.serializer.StringEncoder"))
  }
}

class KafkaProducer[K,V](topic: String, properties: Properties = Props.default) {

  private [this] val config =
    new ProducerConfig(properties)

  val producer: Producer[K, V] =
    new Producer[K,V](config)

  def sendWithKey(key: K, value: V): Unit =
    producer.send(
      new KeyedMessage[K,V](topic, key, value)
    )

  def send(value: V): Unit =
    producer.send(
      new KeyedMessage[K,V](topic, value: V)
    )
}
