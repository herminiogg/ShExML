package es.weso.visitor

trait JdbcDriverRegistry {

  val jdbcDrivers = Map(
    "jdbc:sqlite" -> "org.sqlite.JDBC",
    "jdbc:oracle" -> "oracle.jdbc.OracleDriver",
    "jdbc:mysql" -> "com.mysql.cj.jdbc.Driver",
    "jdbc:postgresql" -> "org.postgresql.Driver",
    "jdbc:sqlserver" -> "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    "jdbc:mariadb" -> "org.mariadb.jdbc.Driver",
    "jdbc:informix-sqli" -> "com.informix.jdbc.IfxDriver",
    "jdbc:hsqldb" -> "org.hsqldb.jdbc.JDBCDriver",
    "jdbc:h2" -> "org.h2.Driver"
  )

  def lookForJdbcDriver(jdbcURL: String, moreDrivers: Map[String, String] = Map()): String = {
    (jdbcDrivers ++ moreDrivers).find(t => jdbcURL.startsWith(t._1)) match {
      case Some(driver) => driver._2
      case None => throw new Exception("No driver found for URL: " + jdbcURL)
    }
  }

}
