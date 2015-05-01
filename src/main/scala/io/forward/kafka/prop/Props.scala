package io.forward.kafka.prop

object Props {
   val default = {
     PropertyBuilder.buildFromMap(
       Map("zk.connect"           -> "127.0.0.1:2181",
           "metadata.broker.list" -> "localhost:9092",
           "serializer.class"     -> "kafka.serializer.StringEncoder"))
   }
 }
