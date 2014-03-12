package controllers

import org.joda.time.DateTime
import scala.concurrent.Future

import play.api.Logger
import play.api.libs.iteratee.Iteratee
import play.api.Play.current
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.modules.reactivemongo.{ MongoController, ReactiveMongoPlugin }

import reactivemongo.api.gridfs.GridFS
import reactivemongo.api.gridfs.Implicits.DefaultReadFileReader
import reactivemongo.api.collections.default.BSONCollection
import reactivemongo.bson._
import scala.concurrent.Future;
import play.api.libs.json.JsValue
import play.api.Routes;
import play.api.libs.json.Json

import models.{Spelling, Article}



object Spellings extends Controller with MongoController {

  // get the collection 'articles'
  val collection = db[BSONCollection]("spelling")
  // a GridFS store named 'attachments'
  //val gridFS = new GridFS(db, "attachments")
  val gridFS = new GridFS(db)

  // let's build an index on our gridfs chunks collection if none
  gridFS.ensureIndex().onComplete {
    case index =>
      Logger.info(s"Checked index, result is $index")
  }

  // list all articles and sort them
  def index = Action.async { implicit request =>
    // get a sort document (see getSort method for more information)
    Logger.info(s"request is $request")
    val sort = getSort(request)
    // build a selection document with an empty query and a sort subdocument ('$orderby')
    val query = BSONDocument(
      "$orderby" -> sort,
      "$query" -> BSONDocument())
    val activeSort = request.queryString.get("sort").flatMap(_.headOption).getOrElse("none")
    // the cursor of documents
  Logger.info(s"query : $query")
    val found = collection.find(query).cursor[Spelling]
    //found.enumerate().apply(Iteratee.foreach { doc =>
    //  println("found document: " + BSONDocument.pretty(doc))
    //})
    // build (asynchronously) a list containing all the articles
    found.collect[List]().map { spellings =>
    Ok(views.html.spellings(spellings, activeSort))
    }.recover {
      case e =>
        e.printStackTrace()
        BadRequest(e.getMessage())
    }
  }

  def generate = Action{ implicit request =>
    val body: AnyContent = request.body
    val jsonBody: Option[JsValue] = body.asJson
    Logger.info(s"jsonBody $jsonBody")
    val words = (jsonBody.getOrElse(null) \ "value").as[List[String]]
    Logger.info(s"words $words")
    val query = BSONDocument(
      "$query" -> BSONDocument(
        "name" ->  BSONDocument(
        "$in" -> BSONArray(words.map({x: String => BSONString(x)})))))

    // the cursor of documents
    Logger.info(s"query : $query")
    val found = collection.find(query).cursor[Spelling]
      found.collect[List]().map { spellings =>
        Logger.info(s"spelling ")
    }
    Ok(Json.toJson("success"))
  }

  def convertSpelling(spelling : Spelling) = {
    //var fillInTheBlankString = spelling.sentences.head
  }

  def jsRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
      controllers.routes.javascript.Spellings.generate))
      .as("text/javascript")
  }

   def removeAttachment(id: String) = Action.async {
    gridFS.remove(new BSONObjectID(id)).map(_ => Ok).recover { case _ => InternalServerError }
  }

  private def getSort(request: Request[_]) = {
    request.queryString.get("sort").map { fields =>
      val sortBy = for {
        order <- fields.map { field =>
          if (field.startsWith("-"))
            field.drop(1) -> -1.0
          else field -> 1.0
        }
        if order._1 == "name" || order._1 == "syllable" || order._1 == "totalSyllabls" || order._1 == "sentences"
      } yield order._1 -> BSONDouble(order._2)
      BSONDocument(sortBy)
    }
  }

  private def getBSonStrings(word :String) = BSONString(word)

}
