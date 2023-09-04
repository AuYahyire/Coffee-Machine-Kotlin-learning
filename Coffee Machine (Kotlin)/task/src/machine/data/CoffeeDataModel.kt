package machine.data

/**
 * Represents a specific coffee type with its properties.
 *
 * @property name The name of the coffee type (e.g., "espresso").
 * @property ingredients A map of coffee ingredients and their quantities along with units.
 * @property price The price of the coffee type.
 */
data class CoffeeDataModel(
    val name: String,
    val ingredients: MutableMap<String, Pair<Int, String>>,
    val price: Int
)
