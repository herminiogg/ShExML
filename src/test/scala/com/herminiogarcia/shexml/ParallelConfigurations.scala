package com.herminiogarcia.shexml

import com.herminiogarcia.shexml.helper.ParallelExecutionConfigurator

class ParallelConfigurations(val parallelConfiguration: ParallelExecutionConfigurator) {

  val parallelConfigurationInferenceDatatypesNormaliseURIs = new MappingLauncher(
    inferenceDatatype = true,
    normaliseURIs = true,
    parallelCollectionConfigurator = parallelConfiguration
  )

  val parallelConfigurationNormaliseURIs = new MappingLauncher(
    inferenceDatatype = false,
    normaliseURIs = true,
    parallelCollectionConfigurator = parallelConfiguration
  )

  val parallelConfigurationDatabase = new MappingLauncher(
    "root",
    "root",
    inferenceDatatype = true,
    normaliseURIs = true,
    parallelCollectionConfigurator = parallelConfiguration
  )

  val parallelConfigurationSparqlNormaliseURIs = new MappingLauncher(
    "root",
    normaliseURIs = true,
    parallelCollectionConfigurator = parallelConfiguration
  )

  val parallelConfigurationSparql = new MappingLauncher(
    "root",
    parallelCollectionConfigurator = parallelConfiguration
  )
}

object ParallelConfigurations {
  val parallelConfigurationAll = new ParallelConfigurations(parallelConfiguration = ParallelExecutionConfigurator("all", "4"))
  val parallelConfigurationShapes = new ParallelConfigurations(parallelConfiguration = ParallelExecutionConfigurator("shapes", "2"))
  val parallelConfigurationQueries = new ParallelConfigurations(parallelConfiguration = ParallelExecutionConfigurator("queries", "6"))
  val nonParallelConfiguration = new ParallelConfigurations(parallelConfiguration = new ParallelExecutionConfigurator(Map(), None))
}
