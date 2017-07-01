package de.d3adspace.hawkings.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class HawkingsConsumerRegistry<ConsumingType> {
	
	private final Map<Integer, Consumer<ConsumingType>> callbacks;
	
	public HawkingsConsumerRegistry() {
		this.callbacks = new ConcurrentHashMap<>();
	}
	
	public void registerConsumer(int consumerId, Consumer<ConsumingType> consumer) {
		this.callbacks.put(consumerId, consumer);
	}
	
	public Consumer<ConsumingType> getConsumer(int consumerId) {
		Consumer<ConsumingType> consumer = this.callbacks.get(consumerId);
		
		callbacks.remove(consumerId);
		
		return consumer;
	}
}
