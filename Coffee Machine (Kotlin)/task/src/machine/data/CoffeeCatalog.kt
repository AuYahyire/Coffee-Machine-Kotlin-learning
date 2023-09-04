package machine.data

/**
 * Stores and manages the available coffee types and their properties.
 * Provides methods to access and retrieve coffee types.
 */
object CoffeeCatalog {
    // List of available coffee types along with their ingredients and prices
    val coffeeList = listOf<CoffeeDataModel>(
        CoffeeDataModel(
            name = "espresso",
            ingredients = mutableMapOf(
                "water" to Pair(250, "ml"),
                "coffee beans" to Pair(16, "g")),
            price = 4
        ),
        CoffeeDataModel(
            name = "latte",
            ingredients = mutableMapOf(
                "water" to Pair(350, "ml"),
                "milk" to Pair(75, "ml"),
                "coffee beans" to Pair(20, "g")
            ),
            price = 7
        ),
        CoffeeDataModel(
            name = "cappuccino",
            ingredients = mutableMapOf(
                "water" to Pair(200, "ml"),
                "milk" to Pair(100, "ml"),
                "coffee beans" to Pair(12, "g")
            ),
            price = 6
        )
    )

    /**
     * Returns a list of available coffee types.
     *
     * @return List of CoffeeDataModel representing available coffee types.
     */
    fun getAvailableTypes(): List<CoffeeDataModel> {
        return coffeeList
    }
}
