package db

import javax.inject.Inject
import play.api.db.Database
import akka.actor.ActorSystem
import scala.concurrent.{Future}
import models.DatabaseExecutionContext

class ScalaApplicationDatabase @Inject() (
    db: Database,
    implicit val databaseExecutionContext: DatabaseExecutionContext
) {
  def updateSomething(): Unit = {
    println("hit function")
    Future {
      db.withConnection { conn =>
        // do whatever you need with the db connection
        println("connected to database")
        val stmt = conn.createStatement()
        val insertQuery =
          "INSERT INTO `scalabackend`.`users` (`name`) VALUES ('Sam');"
        stmt.executeUpdate(insertQuery, Array("id", "name"))
        println("ran insert")
      }
    }(databaseExecutionContext)
  }

}
