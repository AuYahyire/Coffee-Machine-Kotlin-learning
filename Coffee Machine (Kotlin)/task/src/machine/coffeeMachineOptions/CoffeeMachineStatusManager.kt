package machine.coffeeMachineOptions

import machine.data.CoffeeDataModel
import machine.data.CoffeeMachineStatus

/**
 * Manages the status and updates of the coffee machine.
 *
 * @property statusData The CoffeeMachineStatus instance to manage the coffee machine's status.
 */
class CoffeeMachineStatusManager(val statusData: CoffeeMachineStatus) {

    /**
     * Displays the current status of the coffee machine, including supplies, cups, and money.
     */
    fun showStatus() {
        val supplies = statusData.machineOrganicSupplies
        println()
        println("The coffee machine has:")

        // Display each supply's amount and unit
        supplies.forEach { (supply, value) ->
            val amount = value.first
            val unit = value.second
            println("$amount $unit of $supply")
        }

        // Display disposable cups and available money
        println("${statusData.disposableCups} disposable cups")
        println("$${statusData.moneyInMachine} of money")
        println()
    }

    /**
     * Updates the coffee machine status after a coffee purchase.
     *
     * @param coffeeSold The CoffeeDataModel representing the purchased coffee type.
     */
    fun updateStatusAfterBuy(coffeeSold: CoffeeDataModel) {
        // Update money, disposable cups, and supplies after a purchase
        statusData.moneyInMachine += coffeeSold.price
        statusData.disposableCups--

        // Update supplies based on the coffee ingredients sold
        coffeeSold.ingredients.forEach { (ingredient, quantitySold) ->
            val supplyPair = statusData.machineOrganicSupplies[ingredient]
            if (supplyPair != null) {
                val newQuantity = if (supplyPair.first >= quantitySold.first) supplyPair.first - quantitySold.first
                else supplyPair.first
                statusData.machineOrganicSupplies[ingredient] = Pair(newQuantity, supplyPair.second)
            }
        }
    }

    /**
     * Updates the coffee machine status after a supply refill.
     *
     * @param refillValues A map of supplies and their refill amounts.
     */
    fun updateStatusAfterRefill(refillValues: Map<String, Int>) {
        // Update supplies and disposable cups based on refill values
        for ((ingredient, refillAmount) in refillValues) {
            val existingPair = statusData.machineOrganicSupplies[ingredient]
            if (existingPair != null) {
                val modifiedPair = existingPair.copy(first = existingPair.first + refillAmount)
                statusData.machineOrganicSupplies[ingredient] = modifiedPair
            }
        }

        // Update disposable cups after refill if applicable
        val disposableCupsRefill = refillValues["disposable cups"]
        if (disposableCupsRefill != null) {
            statusData.disposableCups += disposableCupsRefill
        }
    }

    /**
     * Updates the coffee machine status after money is taken.
     * Resets the money amount in the machine.
     */
    fun updateStatusAfterTake() {
        statusData.moneyInMachine = 0
    }
}
