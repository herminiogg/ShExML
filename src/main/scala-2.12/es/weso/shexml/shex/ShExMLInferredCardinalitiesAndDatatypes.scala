package es.weso.shexml.shex

case class ShExMLInferredCardinalitiesAndDatatypes(shapeName: String, predicateIRI: String,
                                                   observedCardinality: Int, observedDatatype: Option[String])
