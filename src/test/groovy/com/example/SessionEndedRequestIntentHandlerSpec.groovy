package com.example
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.RequestEnvelope
import com.amazon.ask.model.Response
import com.amazon.ask.model.SessionEndedRequest
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import javax.inject.Inject
import spock.lang.Specification

@MicronautTest
class SessionEndedRequestIntentHandlerSpec extends Specification {

    @Inject
    SessionEndedRequestIntentHandler handler

    void "test SessionEndedRequestIntentHandler"() {
        when:
        SessionEndedRequest request = SessionEndedRequest.builder().build()
        HandlerInput input = HandlerInput.builder()
                .withRequestEnvelope(RequestEnvelope.builder()
                        .withRequest(request)
                        .build()
                ).build()
        then:
        handler.canHandle(input)

        when:
        Optional<Response> responseOptional = handler.handle(input)

        then:
        responseOptional.isPresent()
    }
}
