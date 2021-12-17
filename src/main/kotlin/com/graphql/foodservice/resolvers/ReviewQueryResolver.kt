package com.graphql.foodservice.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.graphql.foodservice.entity.Review
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class ReviewQueryResolver(val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun reviews(): List<Review> {
        val query = Query()
        return mongoOperations.find(query, Review::class.java)
    }

    fun getReviewBySnackId(snackId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }
}