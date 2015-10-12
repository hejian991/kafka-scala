package hj.test

import io.forward.kafka._

/**
 * Created by hj on 15/9/2.
 */


object ProducerTest {

  def main(args: Array[String]) {

    object Props {
      val default = {
        buildFromMap(

          Map(
            // A string that uniquely identifies a set of consumers within the same consumer group
            "group.id" -> "hj-consumer",
            // Reply from the beginning (use largest for new messages only)
            "auto.offset.reset" -> "smallest",
            "zookeeper.connect" -> "nj02-lbs-impala2.nj02.baidu.com:8181",
            // How long to block before giving up when consuming messages (in Milliseconds)
            "consumer.timeout.ms" -> "500",
            "metadata.broker.list" -> "nj02-lbs-impala2.nj02.baidu.com:8192,nj02-lbs-impala4.nj02.baidu.com:8192",
            "serializer.class" -> "kafka.serializer.StringEncoder"
          )

        )
      }
    }

    // Create a producer that will send messages to the "test" topic

    val producer = new KafkaProducer[String, String]("zz", Props.default)

    // Send a message

    producer.send("Hello Kafka!")

    // Send with a key

    producer.sendWithKey("foo", "bar")
  }

}


