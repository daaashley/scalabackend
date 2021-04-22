package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.JsValue

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class UsersController @Inject() (
    val controllerComponents: ControllerComponents
) extends BaseController {

  def createUser() = Action { implicit request: Request[AnyContent] =>
    println("hit create user")
    println(request.contentType)
    println("req: ", request)
    val body = request.body
    println("Body: ", body)
    // body
    //   .map { json =>
    //     Ok("Got: " + (json \ "name").as[String])
    //   }
    //   .getOrElse(
    //     BadRequest("Expecting application/json request body")
    //   )

    Ok("Hit Create User")
  }
}
