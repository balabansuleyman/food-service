package com.graphql.foodservice.repository

import com.graphql.foodservice.entity.Review
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : MongoRepository<Review, String>