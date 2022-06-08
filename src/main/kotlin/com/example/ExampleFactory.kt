package com.example

import io.micronaut.configuration.kafka.streams.ConfiguredStreamBuilder
import io.micronaut.context.annotation.Factory
import org.apache.kafka.streams.kstream.KStream
import javax.inject.Named
import javax.inject.Singleton

@Factory
class ExampleFactory {
    @Singleton
    @Named("example")
    fun exampleStream(builder: ConfiguredStreamBuilder): KStream<String?, String?>? {
        return builder.stream("streams-plaintext-input")
    }
}
