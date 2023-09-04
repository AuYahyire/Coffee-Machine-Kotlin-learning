package machine

import machine.coffeeMachineOptions.CoffeeMachineStatusManager
import machine.coffeeMachineOptions.MenuSelector
import machine.data.*

/**
 * The main entry point of the coffee machine simulation program.
 * Initializes the coffee machine status, menu selector, and handles user interactions.
 */
fun main() {
    // Initialize the coffee machine status with the initial supplies
    val data = CoffeeMachineStatus.initialSupplies

    // Create a CoffeeMachineStatusManager to manage the coffee machine status
    val coffeeMachineStatusManager = CoffeeMachineStatusManager(data)

    // Create a MenuSelector to handle user menu selections
    val menu = MenuSelector(coffeeMachineStatusManager)

    // Show the main menu and handle user interactions
    menu.showMenu()
}

