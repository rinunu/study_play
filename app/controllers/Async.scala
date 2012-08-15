package controllers

import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.iteratee.Enumerator

object Async extends Controller {


  def enumerator = Action {
    Ok.stream(
      Enumerator("kiki", "foo", "bar").andThen(Enumerator.eof)
    )
  }

}
