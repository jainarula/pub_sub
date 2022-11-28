package ProducerBuyer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Buyer implements ISubscriber {
    private final ProducerBuyer producerBuyer;
    private final String name;
    public Buyer(String name, ProducerBuyer producerBuyer) {
        this.name = name;
        this.producerBuyer = producerBuyer;
    }

    @Override
    public void subscribe(String prodCat) {
        Set<String> subscriptionList = producerBuyer.getSubscribers().getOrDefault(name, new HashSet<>());
        subscriptionList.add(prodCat);
        Map<String, Set<String>> subs = producerBuyer.getSubscribers();
        subs.put(name, subscriptionList);
        producerBuyer.setSubscribers(subs);
    }

    @Override
    public void unsubscribe(String prodCat) {
        Set<String> subscriptionList = producerBuyer.getSubscribers().get(name);
        subscriptionList.remove(prodCat);
        Map<String, Set<String>> subs = producerBuyer.getSubscribers();
        subs.put(name, subscriptionList);
        producerBuyer.setSubscribers(subs);
    }

}
