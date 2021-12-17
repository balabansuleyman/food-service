package com.graphql.foodservice.resolvers

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver
import com.graphql.foodservice.entity.Review
import org.reactivestreams.Publisher
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.Random

@Component
class ReviewSubscriptionResolver : GraphQLSubscriptionResolver {

    fun subscribeReviews(): Publisher<Review> {
        val random = Random()
        return Flux.interval(Duration.ofSeconds(1)).map { Review("snackId", random.nextInt(), "text") }
    }
}