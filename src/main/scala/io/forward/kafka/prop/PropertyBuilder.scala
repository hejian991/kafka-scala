package io.forward.kafka.prop

import java.util.Properties

object PropertyBuilder {

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
}
