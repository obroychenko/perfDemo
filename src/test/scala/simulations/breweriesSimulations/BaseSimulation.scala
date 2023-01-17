package simulations.breweriesSimulations

import io.gatling.core.Predef.Simulation
import utils.Helpers

abstract class BaseSimulation extends Simulation {
  before {
    println("Starting the simulation...")
    Helpers.debugInfo()
  }

  after {
    println("Simulation is finished!")
  }
}
