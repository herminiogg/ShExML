package com.herminiogarcia.shexml.shex

class ShapeMapPrinter {

  def print(shapeMaps: List[ShapeMapInference]): String = {
    shapeMaps.map(print).mkString(",")
  }

  def print(shapeMap: ShapeMapInference): String = {
    print(shapeMap.node) + "@" + print(shapeMap.shape)
  }

  def print(node: Node): String = {
    node.prefix + node.value
  }

  def print(shape: ShapeMapShape): String = {
    shape.prefix + shape.name
  }

}
