package com.herminiogarcia.shexml.helper

import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.{ForkJoinTaskSupport, ParSeq}

class ParallelExecutionConfigurator(val parallelisationAspectsOptions: Map[String, Boolean], val numberOfThreads: Option[Int]) {

  def asParallelCollection[T](aspect: String, collection: Seq[T]): Either[Seq[T], ParSeq[T]] = {
    if(!parallelisationAspectsOptions.getOrElse(aspect, false)) Left(collection)
    else numberOfThreads match {
      case Some(number) =>
        collection.par
        val parallelCollection = collection.par
        parallelCollection.tasksupport = new ForkJoinTaskSupport(new java.util.concurrent.ForkJoinPool(number))
        Right(parallelCollection)
      case None => Right(collection.par)
    }
  }
}

object ParallelExecutionConfigurator {

  def apply(parallelAspects: String, numberOfThreads: String): ParallelExecutionConfigurator = {
    val parallelAspectsOptions =
      if(parallelAspects.toLowerCase == "queries") Map[String, Boolean]("queries" -> true)
      else if(parallelAspects.toLowerCase == "shapes") Map[String, Boolean]("shapes" -> true)
      else Map[String, Boolean]("shapes" -> true, "queries" -> true)
    new ParallelExecutionConfigurator(
      parallelAspectsOptions,
      numberOfThreads.toIntOption.filter(_ > 0)
    )
  }

  def empty = new ParallelExecutionConfigurator(Map(), None)
}