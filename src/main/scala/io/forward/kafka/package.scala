package io.forward

import java.util.Properties

package object kafka {

  def stringToBytes(input: String): Array[Byte] =
    input.getBytes("UTF8")

  /**
   * Build a java Properties instance from a Scala Map
   *
   * @param properties An immutable map of properties for Kafka
   */
  def buildFromMap(properties: Map[String, String]) =
    (new Properties /: properties) {
      case (a, (k, v)) =>
        a.put(k,v)
        a
    }

  private [kafka] val defaultProducerProperties = buildFromMap(
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

  private [kafka] val defaultConsumerProperties = buildFromMap(
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
