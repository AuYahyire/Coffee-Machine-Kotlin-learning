package machine.coffeeMachineOptions

import machine.data.CoffeeCatalog
import machine.data.CoffeeDataModel

/**
 * Manages the process of purchasing coffee from the coffee machine.
 *
 * @property data The CoffeeMachineStatusManager instance to manage coffee machine status.
 */
/**
 * Manages the purchasing of coffee and updates the coffee machine's status.
 *
 * @param data The CoffeeMachineStatusManager instance to manage machine status.
 * @param menuSelector The MenuSelector instance for displaying menus.
 */
class PurchaseManager(val data: CoffeeMachineStatusManager, menuSelector: MenuSelector) {
    // Initialize the coffee catalog
    val coffeeCatalog = CoffeeCatalog
    val goBack: () -> Unit = menuSelector::showMenu

    /**
     * Displays the available coffee options to the user and handles coffee purchase.
     * Updates the coffee machine status after a successful purchase.
     */
    fun buyCoffee() {
        println()
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu")
        // Read the user's choice and perform the corresponding action
        when (val selectedCoffee = readln()) {
            in "1".."3" -> performSell(::checkIfEnoughResources, selectedCoffee.toInt())
            "back" -> goBack
            else -> println("Invalid option")
        }
    }

    /**
     * Performs the coffee selling process by checking resources and updating status.
     *
     * @param checkIfEnoughResources A function to check if enough resources are available.
     * @param selectedCoffee The index of the selected coffee in the catalog.
     */
    private fun performSell(checkIfEnoughResources: (CoffeeDataModel) -> Boolean, selectedCoffee: Int) {
        val selectedCoffeeData = coffeeCatalog.coffeeList[selectedCoffee - 1]

        if (checkIfEnoughResources(selectedCoffeeData)) {
            data.updateStatusAfterBuy(selectedCoffeeData)
        } else {
            goBack
        }
    }

    /**
     * Checks if there are enough resources to make the selected coffee.
     *
     * @param coffee The CoffeeDataModel representing the selected coffee.
     * @return True if there are enough resources, false otherwise.
     */
    private fun checkIfEnoughResources(coffee: CoffeeDataModel): Boolean {
        for ((ingredient, quantitySold) in coffee.ingredients) {
            val supplyPair = data.statusData.machineOrganicSupplies[ingredient]
            if (supplyPair == null || supplyPair.first < quantitySold.first) {
                println("Sorry, not enough $ingredient!")
                return false // Ingredient not available in sufficient quantity
            }
        }
        println("I have enough resources, making you a coffee!")
        return true // All ingredients are available in sufficient quantity
    }
}

