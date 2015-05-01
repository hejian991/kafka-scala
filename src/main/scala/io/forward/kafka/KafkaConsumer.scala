package io.forward.kafka

import java.util.Properties

import kafka.consumer._
import kafka.serializer.DefaultDecoder

class KafkaConsumer(topic: String) {

  val defaultProps = {
    val props = new Properties()
    props.put("group.id", "mygroup")
    props.put("zookeeper.connect", "127.0.0.1:2181")
    props.put("metadata.broker.list", "localhost:9092")
    props.put("serializer.class", "kafka.serializer.StringEncoder")
    props
  }

  val config: ConsumerConfig =
    new ConsumerConfig(defaultProps)

  val consumer: ConsumerConnector =
    Consumer.create(config)

  // The topic you want to read from !
  val filterSpec: Whitelist =
    new Whitelist(topic)

  val stream: Option[KafkaStream[Array[Byte], Array[Byte]]] =
    consumer.createMessageStreamsByFilter(
      filterSpec, 1, new DefaultDecoder(), new DefaultDecoder()).headOption

}
