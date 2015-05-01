package io.forward.kafka

import java.util.Properties

import io.forward.kafka.prop.PropertyBuilder
import kafka.consumer._
import kafka.serializer.DefaultDecoder

object DefaultConsumerProps {

  val props: Properties = {
    PropertyBuilder.buildFromMap(
      Map(
        "group.id"             -> "",
        "zookeeper.connect"    -> "127.0.0.1:2181",
        "metadata.broker.list" -> "localhost:9092",
        "serializer.class"     -> "kafka.serializer.StringEncoder")
    )
  }
}

class KafkaConsumer(topic: String, properties: Properties = DefaultConsumerProps.props) {

  val config: ConsumerConfig = new ConsumerConfig(properties)

  val consumer: ConsumerConnector =
    Consumer.create(config)

  // The topic you want to read from !
  val filterSpec: Whitelist =
    new Whitelist(topic)

  val stream: Option[KafkaStream[Array[Byte], Array[Byte]]] =
    consumer.createMessageStreamsByFilter(
      filterSpec, 1, new DefaultDecoder(), new DefaultDecoder()).headOption

}
