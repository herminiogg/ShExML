package com.herminiogarcia.shexml.shex

sealed trait ShapeMapAST

case class ShapeMapInference(node: Node, shape: ShapeMapShape) extends ShapeMapAST

case class Node(prefix: String, value: String) extends ShapeMapAST
case class ShapeMapShape(prefix: String, name: String) extends ShapeMapAST
