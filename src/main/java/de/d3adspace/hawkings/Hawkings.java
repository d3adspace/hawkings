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
		this.registry.registerConsumer(CALLBACK_ID.get(), consumer);
	}
	
	public void invokeConsumer(int consumerId, ConsumingType obj) {
		this.registry.getConsumer(consumerId).accept(obj);
	}
	
	public int incrementAndGetId() {
		return CALLBACK_ID.incrementAndGet();
	}
}
