package io.forward.kafka

import java.util.Properties

import kafka.consumer._
import kafka.serializer._
import scala.util.Try

final class KafkaConsumer[T](
  topic      : String,
  properties : Properties = defaultConsumerProperties,
  decoder    : Decoder[T] = new StringDecoder) {

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
  def apply(topic: String, props: Properties = defaultConsumerProperties): KafkaConsumer[String] =
    new KafkaConsumer[String](topic, props)
}
