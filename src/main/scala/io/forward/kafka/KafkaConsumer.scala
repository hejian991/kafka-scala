package io.forward.kafka

import java.util.Properties

import io.forward.kafka.prop.PropertyBuilder
import kafka.consumer._
import kafka.serializer._
import scala.util.Try

object DefaultConsumerProps {

  val props: Properties =
    PropertyBuilder.buildFromMap(
      Map(
        // A string that uniquely identifies a set of consumers within the same consumer group
        "group.id"             -> "default-consumer",
        // Reply from the beginning (use largest for new messages only)
        "auto.offset.reset"    -> "smallest",
        "zookeeper.connect"    -> "127.0.0.1:2181",
        // How long to block before giving up when consuming messages (in Milliseconds)
        "consumer.timeout.ms"  -> "500",
        "metadata.broker.list" -> "localhost:9092",
        "serializer.class"     -> "kafka.serializer.StringEncoder")
    )
}

class KafkaConsumer[T](
  topic: String,
  properties: Properties = DefaultConsumerProps.props,
  decoder: Decoder[T] = new StringDecoder) {

  val config: ConsumerConfig = new ConsumerConfig(properties)

  val consumer: ConsumerConnector =
    Consumer.create(config)

  // The topic you want to read from !
  val filterSpec: Whitelist =
    new Whitelist(topic)

  val stream: KafkaStream[T, T] =
    consumer.createMessageStreamsByFilter(
      filterSpec, 1, decoder, decoder).head

  def nextMessage(): Option[T] = Try {
    stream.iterator().next().message()
  }.toOption
}

object SimpleStringConsumer {

  def apply(topic: String, props: Properties = DefaultConsumerProps.props): KafkaConsumer[String] =
    new KafkaConsumer[String](topic, props)
}
