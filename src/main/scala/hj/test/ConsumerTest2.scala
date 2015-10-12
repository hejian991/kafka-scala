package hj.test

import io.forward.kafka._

/**
 * Created by hj on 15/10/12.
 */
object ConsumerTest2 {

  object Props {
    val default = {
      buildFromMap(

        Map(
          // A string that uniquely identifies a set of consumers within the same consumer group
          "group.id" -> "hj-consumer",
          // Reply from the beginning (use largest for new messages only)
          "auto.offset.reset" -> "smallest", // "smallest", "largest"
          "zookeeper.connect" -> "szwg-m52-do01-hadoop006.szwg01.baidu.com:2181/do-kafka",
          // How long to block before giving up when consuming messages (in Milliseconds)
          "consumer.timeout.ms" -> "500",
          "metadata.broker.list" -> "do-szwg | szwg-m52-do01-hadoop020.szwg01.baidu.com:9092,szwg-m52-do01-hadoop021.szwg01.baidu.com:9092,szwg-m52-do01-hadoop022.szwg01.baidu.com:9092,szwg-m52-do01-hadoop023.szwg01.baidu.com:9092,szwg-m52-do01-hadoop024.szwg01.baidu.com:9092",
          "serializer.class" -> "kafka.serializer.StringEncoder"
        )
      )

    }
  }

  def main(args: Array[String]) {
    val consumer = new KafkaConsumer[String]("pids-0000000004", Props.default)


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

