package controllers

import play.api.mvc._
import play.api.libs.json.Json

/**
 * Session データは cookie に保存されます。
 *
 * そのため 4kb の制限があることに注意が必要です。
 */
object Sessions extends Controller {

  def save(value: String) = Action { req =>
    req.session + ("test" -> value)
    Ok("saved")
  }

  def get = Action { req =>
    val saved = req.session.get("test")
    Ok(saved.getOrElse("empty"))
  }

  def saveFlash() = Action { req =>
  // Flash は次のリクエストまで有効なデータです
    Redirect(null).flashing("info" -> "flash!")
    Ok("")
  }

  def showFlash() = Action { req =>
    Ok(req.flash("info"))
  }

}
