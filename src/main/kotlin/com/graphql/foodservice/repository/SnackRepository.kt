package com.graphql.foodservice.repository

import com.graphql.foodservice.entity.Snack
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SnackRepository : MongoRepository<Snack, String>