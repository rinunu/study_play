/**
 * == Assets ==
 *
 * デフォルトの設定では、
 * public directory に入っているファイルを
 * /assets/... でアクセスできるようになっています。
 *
 * Etag, Last-Modified 等を付加してくれます。
 */

package controllers

import play.api.mvc._
import play.api.libs.json.Json

object Statics extends Controller {
  def static() = Action { req =>
    Ok(views.html.static())
  }
}
