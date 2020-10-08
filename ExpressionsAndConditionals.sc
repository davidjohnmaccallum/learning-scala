"Match expressions"
"================="

val status = 200
val statusText = status match {
  case 200 => "Ok"
  case 400 => "Client error"
  case 500 => "Server error"
  case other => "Don't know"
}
