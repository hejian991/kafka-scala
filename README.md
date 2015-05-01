# Scala Kafka

![](http://hortonworks.com/wp-content/uploads/2014/08/kafka-logo-wide.png)

## Why?

I wanted some nicer abstractions for working with Apache Kafka 

This will also future proof once the API moves into Java from Scala

# Producer

```scala

import io.forward.kafka._

object Props {
  val default = {
    PropertyBuilder.buildFromMap(
      Map("zk.connect"           -> "127.0.0.1:2181",
          "metadata.broker.list" -> "localhost:9092",
          "serializer.class"     -> "kafka.serializer.StringEncoder"))
  }
}

// Create a producer that will send messages to the "test" topic

val producer = new KafkaProducer[String, String]("test", Props.default)

// Send a message

producer.send("Hello Kafka!")

// Send with a key

producer.sendWithKey("foo", "bar")

```

# Consumer

TODO
