package com.herminiogarcia.shexml.shex

class ShExPrinter {

  def print(shex: ShExSubsetAST, indentation: Int = 0): String = shex match {
    case ShEx(prefixes, shapes, graphs) => {
      prefixes.map(print(_)).mkString("\n") + "\n\n" +
      shapes.map(print(_)).mkString("\n") + "\n" +
      graphs.map(print(_)).mkString("\n")
    }

    case Prefix(name, url) => {
      "PREFIX " + name + " <" + url.url + ">"
    }

    case Graph(name, shapes) => {
      val shapesPrint = shapes.map(print(_, indentation + 1)).mkString("\n")
      name + " [[\n" + shapesPrint + "\n]]"
    }

    case Shape(name, partialFixedValue, predicateObjects) => {
      val partialFixedValuePrint = "IRI" //until confirmation this seems not to be working in ShEx -> print(partialFixedValue)
      val predicateObjectsPrint = predicateObjects.map(print(_, indentation + 1)).mkString("\n")
      generateIndentation(indentation) + name + " " + partialFixedValuePrint + " {\n" +
        predicateObjectsPrint + "\n" + generateIndentation(indentation) + "}"
    }

    case PredicateObject(predicate, objectElement) => {
      val predicatePrint = print(predicate)
      val objectElementPrint = print(objectElement)
      generateIndentation(indentation) + predicatePrint + " " + objectElementPrint + " ;"
    }

    case Predicate(prefix, localname) => {
      prefix + localname
    }

    case ShapeLink(linkedShape) => {
      "@" + linkedShape + " +"
    }

    case ObjectDefinition(datatype, cardinality) => {
      val cardinalityPrint = print(cardinality)
      datatype + " " + cardinalityPrint
    }

    case FixedValue(value) => {
      "[ " + value + " ]"
    }

    case PartialFixedValue(start, cardinality) => {
      val cadinalityPrint = print(cardinality)
      "[ " + start + "~ ]" + " " + cadinalityPrint
    }

    case NumberCardinality(from, to) => {
      if(from == 1 && to == 1) ""
      else "{" + from + "," + to + "}"
    }

    case OptionalCardinality() => {
      "?"
    }

    case ZeroOrMoreCardinality() => {
      "*"
    }

    case OneOrMoreCardinality() => {
      "+"
    }
  }

  private def generateIndentation(indentation: Int): String = {
    val indentationStrings = (0 until indentation).map(_ => "\t")
    indentationStrings.mkString("")
  }

}
