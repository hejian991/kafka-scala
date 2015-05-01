package io.forward.kafka.serialize

trait Serializer {

  def stringToBytes(input: String): Array[Byte] =
    input.getBytes("UTF8")
}
