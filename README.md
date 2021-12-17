# Getting Started

## Running the app

```
./gradlew bootRun
```

Starts the web app on port 9000.

## Querying the Graphql

Navigate to the [GraphiQL UI](http://localhost:9000/index.html)

Example query:

```graphql
mutation {
    newSnack(name: "French Fries", amount: 40.5) {
        id
        name
        amount
    }
}

mutation {
    newReview(snackId:"SNACK_ID", text: "Awesome snack!", rating:5){
        snackId
        text
        rating
    }
}

query {
    snacks {
        name
        reviews {
            text
            rating
        }
    }
}

query {
    reviews {
        text
        rating
    }
}

query {
    getSnackById(snackId: "cc9a1dda-cfe8-4a64-b34b-f09ff9c8f8b2") {
        id
        name
        reviews {
            text
            rating
        }
    }
}

query {
    reviews (snackId: "cc9a1dda-cfe8-4a64-b34b-f09ff9c8f8b2"){
        text
        rating
    }
}

mutation {
    updateSnack(id: "cc9a1dda-cfe8-4a64-b34b-f09ff9c8f8b2", amount: 40.4) {
        id
        name
        amount
    }
}

mutation {
    deleteSnack(id: "cc9a1dda-cfe8-4a64-b34b-f09ff9c8f8b2")
}

subscription {
    subscribeReviews{
        snackId
        rating
        text
    }
}

```
