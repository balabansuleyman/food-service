package com.graphql.foodservice.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.graphql.foodservice.entity.Review
import com.graphql.foodservice.entity.Snack
import com.graphql.foodservice.repository.SnackRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver(val snackRepository: SnackRepository,
                         private val mongoOperations: MongoOperations
) : GraphQLQueryResolver {

    fun snacks(): List<Snack> {
        val list = snackRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(snackId = item.id)
        }
        return list
    }

    fun getSnackById(snackId: String): Snack? {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))

        val snack = snackRepository.findByIdOrNull(snackId)
        snack?.reviews = getReviews(snackId = snack?.id)

        return snack
    }

    private fun getReviews(snackId: String?): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }
}