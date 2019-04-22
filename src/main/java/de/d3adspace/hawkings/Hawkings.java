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

package de.d3adspace.hawkings;

import de.d3adspace.hawkings.exception.NoSuchConsumerException;
import de.d3adspace.hawkings.registry.HawkingsConsumerRegistry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class Hawkings<ConsumingType> {

	/**
	 * The callback id that will be incremented after every new consumer.
	 */
	private final AtomicInteger CALLBACK_ID = new AtomicInteger();

	/**
	 * The registry containing all existent consumers.
	 */
	private final HawkingsConsumerRegistry<ConsumingType> registry;

	/**
	 * Create a new hawkings instanc.e
	 */
	public Hawkings() {
		this.registry = new HawkingsConsumerRegistry<>();
	}

	/**
	 * Register a consumer
	 *
	 * @param consumer The consumer to register.
	 * @return The id of the registered consumer.
	 */
	public int registerConsumer(Consumer<ConsumingType> consumer) {
		int callbackId = CALLBACK_ID.getAndIncrement();
		registry.registerConsumer(callbackId, consumer);
		return callbackId;
	}

	/**
	 * Invoke the consumer with the given id using the given argument.
	 *
	 * @param consumerId The consumer id.
	 * @param obj The argument to consume.
	 */
	public void invokeConsumer(int consumerId, ConsumingType obj) {
		Consumer<ConsumingType> consumer = this.registry.getConsumer(consumerId);

		if (consumer == null) {
			throw new NoSuchConsumerException("There is no consumer with id " + consumerId);
		}

		consumer.accept(obj);
	}
}
