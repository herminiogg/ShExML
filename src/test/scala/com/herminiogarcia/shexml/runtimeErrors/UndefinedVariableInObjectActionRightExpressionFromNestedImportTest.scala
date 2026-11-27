package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import com.herminiogarcia.shexml.helper.RDFGenerationError
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class UndefinedVariableInObjectActionRightExpressionFromNestedImportTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |IMPORT <src/test/resources/importTestIterators.shexml>
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |IMPORT <src/test/resources/importTestShapesLevel1WithError.shexml>
    """.stripMargin

  test("Undefined variable in an action expression is detected") {
    val precompiledRules = mappingLauncher.resolveImports(example)
    val error = intercept[RDFGenerationError] {
      mappingLauncher.launchMapping(example)
    }
    assert(error.message == "Variable films.actresses.nome does not resolve to any reference, check the used variable or the iterator definition")
    assert(error.getEnrichedErrorMessage(precompiledRules).contains("51:     :name [films.[1m[4mactresses.nome[22m[24m] ;"))
  }

}
