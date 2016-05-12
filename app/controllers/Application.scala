package controllers

import javax.inject._
import scala.concurrent.Future
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Reads._


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Application @Inject() extends Controller {

  
  def index = Action {
    Ok("Your new application is ready.")
  }

  case class FooStuff(foo:String)

  val FooStuffReads = Json.reads[FooStuff]

  def fooStuff = Action.async(parse.json) { implicit request => 
		request.body.validate(FooStuffReads).map { foo =>
			Future.successful(Ok(Json.obj("res" -> foo.foo)))
		}.recoverTotal { e =>
			val jsonError = JsError.toJson(e)
		  Future.successful(BadRequest(jsonError))
		}
	}

}
