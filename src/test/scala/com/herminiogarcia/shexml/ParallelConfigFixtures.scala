package com.herminiogarcia.shexml

import com.herminiogarcia.shexml.helper.ParallelExecutionConfigurator
import org.scalatest.{BeforeAndAfterAllConfigMap, ConfigMap, TestSuite}


trait ParallelConfigInferenceDatatypesNormaliseURIsFixture extends BeforeAndAfterAllConfigMap with MappingLauncherInitializer { this: TestSuite =>
  var mappingLauncher: MappingLauncher = _

  override def beforeAll(configMap: ConfigMap): Unit = {
    mappingLauncher = configMapToParallelConfiguration(configMap).parallelConfigurationInferenceDatatypesNormaliseURIs
    super.beforeAll(configMap)
  }
}

trait ParallelConfigNormaliseURIsFixture extends BeforeAndAfterAllConfigMap with MappingLauncherInitializer { this: TestSuite =>
  var mappingLauncher: MappingLauncher = _

  override def beforeAll(configMap: ConfigMap): Unit = {
    mappingLauncher = configMapToParallelConfiguration(configMap).parallelConfigurationNormaliseURIs
    super.beforeAll(configMap)
  }
}

trait ParallelConfigDatabase extends BeforeAndAfterAllConfigMap with MappingLauncherInitializer { this: TestSuite =>
  var mappingLauncher: MappingLauncher = _

  override def beforeAll(configMap: ConfigMap): Unit = {
    mappingLauncher = configMapToParallelConfiguration(configMap).parallelConfigurationDatabase
    super.beforeAll(configMap)
  }
}

trait ParallelConfigSparqlNormaliseURIs extends BeforeAndAfterAllConfigMap with MappingLauncherInitializer { this: TestSuite =>
  var mappingLauncher: MappingLauncher = _

  override def beforeAll(configMap: ConfigMap): Unit = {
    mappingLauncher = configMapToParallelConfiguration(configMap).parallelConfigurationSparqlNormaliseURIs
    super.beforeAll(configMap)
  }
}

trait ParallelConfigSparql extends BeforeAndAfterAllConfigMap with MappingLauncherInitializer { this: TestSuite =>
  var mappingLauncher: MappingLauncher = _

  override def beforeAll(configMap: ConfigMap): Unit = {
    mappingLauncher = configMapToParallelConfiguration(configMap).parallelConfigurationSparql
    super.beforeAll(configMap)
  }
}

trait ParallelConfigValidation extends BeforeAndAfterAllConfigMap with MappingLauncherInitializer { this: TestSuite =>
  var parallelConfiguration: ParallelExecutionConfigurator = _

  override def beforeAll(configMap: ConfigMap): Unit = {
    parallelConfiguration = configMapToParallelConfiguration(configMap).parallelConfigurationInferenceDatatypesNormaliseURIs.parallelCollectionConfigurator
    super.beforeAll(configMap)
  }
}

trait MappingLauncherInitializer {
  def getParallelConfig(parallelConfig: String): ParallelConfigurations = {
    if(parallelConfig == "all") ParallelConfigurations.parallelConfigurationAll
    else if(parallelConfig == "shapes") ParallelConfigurations.parallelConfigurationShapes
    else if(parallelConfig == "queries") ParallelConfigurations.parallelConfigurationQueries
    else ParallelConfigurations.nonParallelConfiguration
  }

  def configMapToParallelConfiguration(configMap: ConfigMap): ParallelConfigurations = configMap.get("parallel") match {
    case Some(parallelConfig) => getParallelConfig(parallelConfig.asInstanceOf[String])
    case None => ParallelConfigurations.nonParallelConfiguration
  }


}
