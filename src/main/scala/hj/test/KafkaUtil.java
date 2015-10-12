//package hj.test;
//
//import com.babyduncan.kafkaClient.constants.ConsumerConstants;
//import com.babyduncan.kafkaClient.constants.ProducerConstants;
//import com.babyduncan.kafkaClient.message.ThriftMessageSerializer;
//import kafka.consumer.ConsumerConfig;
//import kafka.producer.ProducerConfig;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @author: guohaozhao babyduncan@qq.com
// * @since: 13-4-15 16:34
// */
//public final class KafkaUtil {
//    private KafkaUtil() {/**/}
//
//    /**
//     * ����kafka������������
//     *
//     * @param configMap
//     * @return
//     */
//
//    public static ConsumerConfig createConsumerConfig(Map<String, String> configMap) {
//        Properties props = new Properties();
//        for (Map.Entry<String, String> entry : configMap.entrySet()) {
//            props.put(entry.getKey(), entry.getValue());
//        }
//        return new ConsumerConfig(props);
//    }
//
//    /**
//     * ����kafka������������
//     *
//     * @param configMap
//     * @return
//     */
//
//    public static ProducerConfig createProducerConfig(Map<String, String> configMap) {
//        Properties props = new Properties();
//        for (Map.Entry<String, String> entry : configMap.entrySet()) {
//            props.put(entry.getKey(), entry.getValue());
//        }
//        return new ProducerConfig(props);
//    }
//
//    public static ProducerConfig getDefaultProducerConfig() {
//        Map<String, String> configMap = new HashMap<String, String>();
//        for (String[] entry : ProducerConstants.DEFAULT_CONFIG) {
//            configMap.put(entry[0], entry[1]);
//        }
//        configMap.put("zk.connect", ZkUtil.getRootPath());
//        return createProducerConfig(configMap);
//    }
//
//    public static ProducerConfig getThriftProducerConfig() {
//        Map<String, String> configMap = new HashMap<String, String>();
//        for (String[] entry : ProducerConstants.DEFAULT_CONFIG) {
//            configMap.put(entry[0], entry[1]);
//        }
//        configMap.put("zk.connect", ZkUtil.getRootPath());
//        configMap.put("serializer.class", ThriftMessageSerializer.class.getName());
//        return createProducerConfig(configMap);
//    }
//
//    public static ConsumerConfig getDefaultConsumerConfig() {
//        Map<String, String> configMap = new HashMap<String, String>();
//        for (String[] entry : ConsumerConstants.DEFAULT_CONFIG) {
//            configMap.put(entry[0], entry[1]);
//        }
//        configMap.put("zk.connect", ZkUtil.getRootPath());
//        return createConsumerConfig(configMap);
//    }
//}
//
