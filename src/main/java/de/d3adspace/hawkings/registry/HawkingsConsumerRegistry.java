/*
 * Copyright (c) 2017 D3adspace
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.d3adspace.hawkings.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class HawkingsConsumerRegistry<ConsumingType> {

	/**
	 * Contains all known callbacks.
	 */
	private final Map<Integer, Consumer<ConsumingType>> callbacks;

	/**
	 * Create a new consumer egistry.
	 */
	public HawkingsConsumerRegistry() {
		this.callbacks = new ConcurrentHashMap<>();
	}

	/**
	 * Register a consumer using the given id.
	 *
	 * @param consumerId The consumer id.
	 * @param consumer The consumer.
	 */
	public void registerConsumer(int consumerId, Consumer<ConsumingType> consumer) {
		this.callbacks.put(consumerId, consumer);
	}

	/**
	 * Load the consumer with the given id.
	 *
	 * @param consumerId The id.
	 * @return The consumer.
	 */
	public Consumer<ConsumingType> getConsumer(int consumerId) {
		Consumer<ConsumingType> consumer = this.callbacks.get(consumerId);

		callbacks.remove(consumerId);

		return consumer;
	}

	/**
	 * Check if there is a consumer with the given id.
	 */
	public boolean hasConsumer(int consumerId) {
		return this.callbacks.containsKey(consumerId);
	}
}
