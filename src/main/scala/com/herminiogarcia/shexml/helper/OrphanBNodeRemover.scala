package com.herminiogarcia.shexml.helper

import org.apache.jena.rdf.model.Model
import collection.JavaConverters._

class OrphanBNodeRemover {

  def removeOrphanBNodes(model: Model) {
    model.listStatements().toList.asScala.foreach(s => {
      val subject = s.getSubject
      if(subject.isAnon) {
        val sID = subject.getId
        val isLinked = model.listObjects().asScala.exists(o => o.isAnon && o.asResource().getId.equals(sID))
        if(!isLinked) model.remove(s)
      }
    })
  }

}
