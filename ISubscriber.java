package ProducerBuyer;

public interface ISubscriber {
    void subscribe(String prodCat);
    void unsubscribe(String prodCat);
}
