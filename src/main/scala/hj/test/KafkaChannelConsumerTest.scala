package hj.test

import io.forward.kafka._

/**
 * Created by hj on 15/9/2.
 */
object KafkaChannelConsumerTest {

  object Props {
    val default = {
      buildFromMap(

        Map(
          // A string that uniquely identifies a set of consumers within the same consumer group
          "group.id" -> "hj-kafkaChannel-consumer",
          // Reply from the beginning (use largest for new messages only)
          "auto.offset.reset" -> "smallest", // "smallest",
          "zookeeper.connect" -> "nj02-lbs-impala2.nj02.baidu.com:8181",
          // How long to block before giving up when consuming messages (in Milliseconds)
          "consumer.timeout.ms" -> "500",
          "metadata.broker.list" -> "nj02-lbs-impala2.nj02.baidu.com:8192,nj02-lbs-impala4.nj02.baidu.com:8192",
          "serializer.class" -> "kafka.serializer.DefaultEncoder" //"kafka.serializer.StringEncoder" // org.apache.flume.serialization.FlumeEventAvroEventSerializer$Builder
        // kafka.serializer.DefaultEncoder
        )
      )

    }
  }

  def main(args: Array[String]) {
    val consumer = new KafkaConsumer[String]("taildir_kafka_hdfs.c1", Props.default)


    while (true) {
      Thread.sleep(1000)
      println(consumer.nextMessage())
    }

//    val stream = consumer.stream.get
//    val it = stream.iterator()
//    while (it.hasNext()) {
//      val t =it.next().message()
//      println(t)
//    }




    // Get a message

    // scala> consumer.nextMessage()
    // res1: Option[String] = Some("Hello world")

    // scala> consumer.nextMessage()
    // res2: Option[String] = None
  }

}

