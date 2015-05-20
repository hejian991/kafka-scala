package io.forward.kafka

import org.scalatest._

class KafkaConsumerSpec extends FunSpec with Matchers {

  describe("The Kafka Consumer") {

    val TopicUnderTest = "analyticsTopic"

    it("should create a new instance") {

      val producer = SimpleStringConsumer(TopicUnderTest)

      producer shouldBe a[KafkaConsumer]
    }
  }
}
