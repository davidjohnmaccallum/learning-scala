import scala.collection.mutable

case class Content(
  id: String,
  kind: String,
  text: String,
  visible: Boolean
)

val contentCc = Set(
  Content("1", "text", "Hello world!", visible = true),
  Content("2", "text", "Hello new world!", visible = true),
  Content("3", "text", "Rejoice in the Lord always", visible = true)
)

contentCc.map(it => it.copy(kind = "string"))

val contentCcCc = List(
  Set(
    Content("1", "text", "Hello world!", visible = true),
    Content("2", "text", "Hello new world!", visible = true),
    Content("3", "text", "Rejoice in the Lord always", visible = true)
  ),
  Set(
    Content("1", "text", "Hello world!", visible = true),
    Content("2", "text", "Hello new world!", visible = true),
    Content("3", "text", "Rejoice in the Lord always", visible = true)
  ),
  Set(
    Content("1", "text", "Hello world!", visible = true),
    Content("2", "text", "Hello new world!", visible = true),
    Content("3", "text", "Rejoice in the Lord always", visible = true)
  )
)

contentCcCc.flatten.map(it => it.copy(kind = "string"))

val contentMap = Set(
  mutable.Map("id" -> "1", "type" -> "text", "text" -> "Hello world!", "visible" -> true),
  mutable.Map("id" -> "2", "type" -> "text", "text" -> "Hello new world!", "visible" -> true),
  mutable.Map("id" -> "3", "type" -> "text", "text" -> "Rejoice in the Lord always", "visible" -> true)
)

contentMap.map(it => {
  it("type") = "string"
  it
})
