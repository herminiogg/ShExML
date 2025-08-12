package com.herminiogarcia.shexml.helper

import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.ParSeq

class ParallelExecutionConfigurator(override val parallelisationAspectsOptions: Map[String, Boolean], override val numberOfThreads: Option[Int])
  extends ParallelExecutionConfiguratorGen(parallelisationAspectsOptions, numberOfThreads) {

  override protected def convertToParallelCollection[T](collection: Seq[T]): ParSeq[T] = {
    collection.par
  }
}

object ParallelExecutionConfigurator extends ParallelExecutionConfiguratorTrait