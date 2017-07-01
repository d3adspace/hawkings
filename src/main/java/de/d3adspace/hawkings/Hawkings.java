package de.d3adspace.hawkings;

import de.d3adspace.hawkings.registry.HawkingsConsumerRegistry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class Hawkings<ConsumingType> {
	
	private final AtomicInteger CALLBACK_ID = new AtomicInteger();
	private final HawkingsConsumerRegistry<ConsumingType> registry;
	
	public Hawkings() {
		this.registry = new HawkingsConsumerRegistry<>();
	}
	
	public void registerConsumer(Consumer<ConsumingType> consumer) {
		this.registry.registerConsumer(CALLBACK_ID.incrementAndGet(), consumer);
	}
	
	public void invokeConsumer(int consumerId, ConsumingType obj) {
		this.registry.getConsumer(consumerId).accept(obj);
	}
}
